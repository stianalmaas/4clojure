(ns fourclojure.120)

Sum of square of digits
 
Difficulty:	Easy
Topics:	math


Write a function which takes a collection of integers as an argument. Return the count of how many elements are smaller than the sum of their squared component digits. For example: 10 is larger than 1 squared plus 0 squared; whereas 15 is smaller than 1 squared plus 5 squared.
	
(= 8 (__ (range 10)))
	
(= 19 (__ (range 30)))
	
(= 50 (__ (range 100)))
	
(= 50 (__ (range 1000)))



(def data (range 10))


(map #(map ( fn[t]()) ( str %)) data)


(map (fn [n] (if ) (let [v (Integer/parseInt (str n))] (* v v))) (str  8) )

(reduce #(+ % (* %2 %2)) 0 [1 0])

(map ( fn [c] (Integer/parseInt (str c))) "15")

()

(doc reduce)
