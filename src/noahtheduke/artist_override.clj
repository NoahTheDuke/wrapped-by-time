(ns noahtheduke.artist-override)

(defn normalize-artist [artist]
  (case artist
    "Hemachandra Vedala" "M. M. Keeravani"
    "Amit Trivedi" "M. M. Keeravani"
    "Matthew S Burns" "Matthew S. Burns"
    ; else
    artist))

