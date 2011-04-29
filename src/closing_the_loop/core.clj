(ns closing-the-loop.core)

(defn split [line]
  (re-seq #"[^\s]+" line))

(defn length-color [segment]
  [(Integer/parseInt (first (re-seq #"[0-9]+" segment)))
   (first (re-seq #"[R|B]" segment))])

(defn line-to-segments [line]
  (map #(length-color %) (split line)))
  
(defn split-by-color [line]
  (let [segments (line-to-segments line)]
    [(filter #(= "R" (second %)) segments)
     (filter #(= "B" (second %)) segments)]))
  
