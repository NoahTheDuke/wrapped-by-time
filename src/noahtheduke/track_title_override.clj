(ns noahtheduke.track-title-override)

(defn normalize-track-title [track]
  (case track
    "Dosti (From \"RRR\")" "Dosti"
    "Etthara Jenda (From \"RRR\")" "Etthara Jenda"
    "Janani (From \"Rrr\")" "Janani"
    "Komuram Bheemudo (From \"RRR\")" "Komuram Bheemudo"
    "Naatu Naatu (From \"Rrr\")" "Naatu Naatu"
    "Raamam Raaghavam (From \"Rrr\")" "Raamam Raaghavam"
    ; else
    track))
