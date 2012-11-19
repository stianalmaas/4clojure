(ns fourclojure.63)


;; Given a function f and a sequence s, write a function which returns a map. The keys should be the values of f applied to each item in s. The value at each key should be a vector of corresponding items in the order they appear in s.
	
;; (= (__ #(> % 5) [1 3 6 8]) {false [1 3], true [6 8]})
	
;; (= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]]) {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})
	
;; (= (__ count [[1] [1 2] [3] [1 2 3] [2 3]]) {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})

(defn funk [x] (> x 5))

(def tall [1 3 6 8])

(def tmp (map #(vector (funk %) %) tall) )


(def tmp (map #(hash-map (funk %) (vector %)) tall))

(apply merge-with concat tmp)

#(apply merge-with concat (map #(hash-map (funk %) (vector %)) tall))


(reduce ( fn [c v] (assoc c (funk v) (conj (get c (funk v) []) v))) {} [1 3 6 8])

( #(reduce ( fn [c v] (assoc c (% v) (conj (get c (% v) []) v))) {} %2) #(> % 5) [1 3 6 8])


;; Darren
#(reduce (fn [m e] (assoc m (% e) (conj (m (% e) []) e))) {} %2)

;; amalloy
#(apply merge-with into
        (for [x %2]
          {(% x) [x]}))

;; chouser
#(reduce
(fn [m x] (assoc m (% x) (conj (m (% x) []) x))) 
{} %2)

;; cgrand

#(apply merge-with into (map (fn [x] {(% x) [x]}) %2))



