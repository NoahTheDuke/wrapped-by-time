(ns noahtheduke.lfm-timer
  (:require
   [babashka.http-client :as http]
   [clojure.data.json :as json]
   [clojure.edn :as edn]
   [clojure.pprint :as cpp]
   [clojure.string :as str]
   [noahtheduke.album-mbid-override :refer [manual-album-mbid]]
   [noahtheduke.artist-override :refer [normalize-artist]]
   [noahtheduke.track-title-override :refer [normalize-track-title]]))

(def last-fm-url "https://ws.audioscrobbler.com/2.0")
(def last-fm-api-key "bc139a6bdeaa921ed70e49ca9a21f683")

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn spy [x]
  (prn x)
  x)

(defn mb-url [mbid]
  (format "https://musicbrainz.org/ws/2/release/%s" mbid))

(def user-agent "noahtheduke.last-fm-timer/0.0.1 ( noah.bogart@hey.com )")

(defn http-get [url req]
  (let [resp (http/get url req)
        json-body (json/read-str (:body resp) {:key-fn keyword})]
    (assoc resp :json json-body)))

(def start-ts
  (-> #inst "2023-01-01T00:00:01"
      (.toInstant)
      (.toEpochMilli)
      (/ 1000)))

(def end-ts
  (-> #inst "2024-01-01T00:00:01"
      (.toInstant)
      (.toEpochMilli)
      (/ 1000)))

(def manual-album-artist
  {
   "RRR" "M. M. Keeravani"
   "Dosti (From \"RRR\")" "M. M. Keeravani"
   "Etthara Jenda (From \"RRR\")" "M. M. Keeravani"
   "Janani (From \"Rrr\")" "M. M. Keeravani"
   "Komuram Bheemudo (From \"RRR\")" "M. M. Keeravani"
   "Naatu Naatu (From \"Rrr\")" "M. M. Keeravani"
   "Raamam Raaghavam (From \"Rrr\")" "M. M. Keeravani"
   "Roar Of RRR" "M. M. Keeravani"
   "Rrr Ost Vol-1" "M. M. Keeravani"
   "Rrr Ost Vol-2" "M. M. Keeravani"
   "Rrr Ost Vol-3" "M. M. Keeravani"
   "Rrr Ost Vol-4" "M. M. Keeravani"
   "Rrr Ost Vol-7" "M. M. Keeravani"
   "Kirby and the Forgotten Land Original Soundtrack" "Nintendo"
   "Kirby and the Forgotten Land Original Soundtrack (Loop)" "Nintendo"
   })

(def albums-to-skip
  #{"101 Dalmatians"
    "Toto IV"})

(defonce raw-json
  (->> (iteration
         (fn [page]
           (http-get last-fm-url
                     {:query-params
                      {:method "user.getRecentTracks"
                       :user "noahtheduke"
                       :limit "500"
                       :page page
                       :from start-ts
                       :to end-ts
                       :api_key last-fm-api-key
                       :format "json"}
                      :headers {:user-agent user-agent}}))
         {:initk "1"
          :vf (fn [{:keys [json]}]
                (let [{:keys [page totalPages]} (-> json :recenttracks ((keyword "@attr")))]
                  (println (format "Processing page %s of %s" page totalPages)))
                (-> json :recenttracks :track))
          :kf (fn [resp]
                (let [{:keys [page totalPages]}
                      (-> resp :json :recenttracks ((keyword "@attr")))]
                  (when (<= (parse-long page)
                            (parse-long totalPages))
                    (inc (parse-long page)))))
          :somef (fn [resp] (= 200 (:status resp)))})
     (sequence cat)
     (into [])))

(defn recent-tracks []
  (->> raw-json
       (keep (fn [scrobble]
              (let [artist (-> scrobble :artist :#text normalize-artist)
                    album (-> scrobble :album :#text (str/replace \’ \'))
                    artist (get manual-album-artist album artist)
                    album-mbid (-> scrobble :album :mbid)
                    overrides (manual-album-mbid
                                {:artist artist
                                 :album album
                                 :album-mbid album-mbid})
                    normalized-album (or (:normalized-album overrides) album)
                    album-mbid (or (:album-mbid overrides) album-mbid)
                    title (-> (:name scrobble)
                              (str/replace \’ \')
                              (normalize-track-title))]
                (when-not (albums-to-skip album)
                  {:artist artist
                   :image-url (->> (:image scrobble)
                                   (filter #(= "medium" (:size %)))
                                   (first)
                                   (:#text))
                   :album normalized-album
                   :album-mbid album-mbid
                   :mbid (:mbid scrobble)
                   :title title}))))))

(comment
  (->> (recent-tracks)
       (filter #(= "M. M. Keeravani" (:artist %)))
       ; count #_
       (map (juxt :artist :album :title :album-mbid))))

(defn albums-by-count []
  (->> (recent-tracks)
       (reduce
         (fn [acc cur]
           (let [{:keys [album album-mbid title]} cur
                 existing (get acc album)
                 existing (cond
                            (nil? existing)
                            (assoc cur :play-count {})
                            (str/blank? (:album-mbid existing ""))
                            (assoc existing :album-mbid album-mbid)
                            :else
                            existing)
                 existing (-> existing
                              (update-in [:play-count title] (fnil inc 0))
                              (update :total-play-count (fnil inc 0)))]
             (assoc! acc album existing)))
         (transient {}))
       (persistent!)))

(defn albums-to-check []
  (->> (albums-by-count)
       vals
       (filter (comp not str/blank? :album-mbid))
       (sort-by (comp str/lower-case :album))
       (into [])))

(comment
  (albums-to-check)
  (->> (albums-by-count)
       vals
       (filter #(pos? (:total-play-count %)))
       (filter (comp str/blank? :album-mbid))
       (map (juxt :artist :album :album-mbid :total-play-count))
       (sort-by last >)
       (into [])
       ; count
       ))

(defn mb-get [mbid]
  (let [req {:query-params {:fmt "json"
                            :inc "recordings"}
             :headers {:User-Agent user-agent}}]
    (try (:json (http-get (mb-url mbid) req))
         (catch Exception ex
           (prn mbid (ex-message ex))))))

(def album-data
  (let [existing (try (edn/read-string (slurp "album-data.edn"))
                      (catch Exception _ {}))]
    (atom existing)))

(doseq [{:keys [album album-mbid]} (albums-to-check)
        :when (not (contains? @album-data [album album-mbid]))]
  (Thread/sleep 500)
  (println (format "Querying for %s" album))
  (when-let [album-info (mb-get album-mbid)]
    (let [mb-tracks
          (->> (-> album-info :media first :tracks)
               (map (fn [t]
                      [(:title t) (:length t)]))
               (into {}))]
      (swap! album-data assoc [album album-mbid] mb-tracks))))

(spit "album-data.edn"
      (with-out-str
        (cpp/pprint @album-data)))

(defn time-str [milliseconds]
  (let [seconds (int (/ milliseconds 1000))
        total-minutes (int (/ seconds 60))
        leftover-seconds (int (rem seconds 60))
        total-hours (int (/ total-minutes 60))
        leftover-minutes (int (rem total-minutes 60))]
    (format "%d:%02d:%02d" total-hours leftover-minutes leftover-seconds)))

(defn normalize-track [track]
  (-> track
      (str/lower-case)
      (str/replace \’ \')))

(defn combined-album-play-time []
  (->> (albums-to-check)
       (group-by :album)
       (mapv
         (fn [[n-a albums]]
           (let [{artist :artist :as album-obj} (first albums)
                 track-times (->> albums
                                  (mapcat (fn [{:keys [album album-mbid]}]
                                            (-> (get @album-data [album album-mbid])
                                                (update-keys normalize-track))))
                                  (into {}))
                 track-play-count (->> albums
                                       (map :play-count)
                                       (apply merge-with +))
                 combined (->> (for [[title play-count] track-play-count
                                     :let [lc-title (normalize-track title)
                                           length (get track-times lc-title 0)]]
                                 [lc-title {:title title
                                            :artist artist
                                            :album n-a
                                            :play-count play-count
                                            :length length
                                            :total-time (* play-count length)
                                            :time-str (time-str (* play-count length))}])
                               (into {}))
                 total-play-count (->> combined
                                       (vals)
                                       (map :play-count)
                                       (reduce (fnil + 0 0) 0))
                 total-play-seconds (->> combined
                                         (vals)
                                         (map :total-time)
                                         (reduce (fnil + 0 0) 0))
                 desired-album-mbid (->> albums
                                         (filter #(= n-a (:album %)))
                                         (first)
                                         :album-mbid)
                 {:keys [album-mbid]} (manual-album-mbid
                                        {:artist artist
                                         :album n-a
                                         :album-mbid desired-album-mbid})
                 album-obj (-> album-obj
                               (assoc :album-mbid album-mbid)
                               (assoc :combined combined)
                               (assoc :total-play-count total-play-count)
                               (assoc :total-play-time total-play-seconds)
                               (assoc :time-str (time-str total-play-seconds)))]
             album-obj)))))

;; top albums by play time
(->> (combined-album-play-time)
     (sort-by :total-play-time >)
     (take 25)
     (map-indexed
       (fn [idx elem]
         (->> (cons (inc idx)
                    ((juxt :artist :album :total-play-count :time-str ) elem))
              (str/join " | "))))
     (str/join "\n")
     (println))

;; top tracks by play time
(->> (combined-album-play-time)
     (mapcat (comp vals :combined))
     (sort-by :total-time >)
     (take 25)
     (map #(->> ((juxt :artist :title :play-count :time-str) %)
                (str/join " | ")))
     (str/join "\n")
     (println))

;; top artists by play time
(->> (combined-album-play-time)
     (group-by :artist)
     (map (fn [[artist albums]]
            (let [total-play-count
                  (->> (keep :total-play-count albums)
                       (reduce (fnil + 0 0) 0))
                  total-play-time
                  (->> (keep :total-play-time albums)
                       (reduce (fnil + 0 0) 0))]
              {:artist artist
               :total-play-count total-play-count
               :total-play-time total-play-time
               :time-str (time-str total-play-time)})))
     (sort-by :total-play-time >)
     (take 25)
     (map #(->> ((juxt :artist :total-play-count :time-str) %)
                (str/join " | ")))
     (str/join "\n")
     (println))
