(ns four-clojure.core)


; Pascal's triangle is a triangle of numbers computed using the following rules:

; - The first row is 1.
; - Each successive row is computed by adding together adjacent numbers in the row above, and adding a 1 to the beginning and end of the row.

; Write a function which returns the nth row of Pascal's Triangle. 

(defn triangle [n]
  (cond
   (= n 1) [1]
   (= n 2) [1 1]
   :else (concat '(1) (map #(apply + %)  (partition 2 1  (triangle (- n 1)))) '(1))))

(def four [1 3 3 1])

(def tmp  (partition-all 2 1 four))

(map #(apply + %) tmp)

(for [x four] )


; cgrand's solution:
(fn [n]
  (nth (iterate #(concat [1] (map + % (next %)) [1]) [1]) (dec n)))

; chouser's solution:
(fn p [x]
  (if (= x 1)
    [1]
    `[1 ~@(map + (p (- x 1)) (next (p (- x 1)))) 1]))



(comment 
  (= (__ 1) [1]))

(comment 
  (= (map __ (range 1 6))
     [     [1]
           [1 1]
           [1 2 1]
           [1 3 3 1]
           [1 4 6 4 1]]))
	
(comment 
  (= (__ 11)
     [1 10 45 120 210 252 210 120 45 10 1]))


