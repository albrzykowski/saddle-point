(ns saddle-point.core
  (:use [clojure.set :only [intersection]] :reload))    
        
(defn- find-thing [needle haystack]
  (keep-indexed #(when (= %2 needle) %1) haystack))
        
(defn find-min-indexes [row]
  (find-thing (apply min row) row))
  
(defn- find-max-indexes [row]
  (find-thing (apply max row) row))
   
(defn- transpose [matrix]
  (apply mapv vector matrix))
  
(defn- find-suspected-points [matrix fn] 
  (loop [row-idx 0 suspected-points ()]
    (def row (seq (get matrix row-idx)))
    (if (nil? row)
      suspected-points
      (recur 
        (inc row-idx)
        (into suspected-points 
        (for [col-idx (fn row)] 
          (list row-idx col-idx)))))))
        
(defn find-saddle-points [matrix]
  (def col-mins (into #{} (find-suspected-points matrix find-min-indexes)))
  (def row-maxs (into #{} (map reverse (find-suspected-points (transpose matrix) find-max-indexes))))
  (intersection col-mins row-maxs))

(defn has-saddle-points? [matrix]
  (if (empty? (find-saddle-points matrix)) false true))