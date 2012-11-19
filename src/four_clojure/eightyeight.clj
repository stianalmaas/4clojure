(ns fourclojure.88)

;Write a function which returns the symmetric difference of two sets. The symmetric difference is the set of items belonging to one but not both of the two sets.

(def one #{1 2 3 4 5 6})

(def two #{1 3 5 7})

(for [x one :let [y (two x)] :when (not (= x y))] x)

(comment 
  (= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}))

(comment 
  (= (__ #{:a :b :c} #{}) #{:a :b :c}))

(comment 
  (= (__ #{} #{4 5 6}) #{4 5 6}))

(comment 
  (= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]}))


(conj  (filter one two) (filter two one))


(apply conj (reduce disj one two) (reduce disj two one))


;; chouser
#(into (set (remove %2 %)) (remove % %2))

;; cgrand
#(set (concat (remove % %2) (remove %2 %)))



