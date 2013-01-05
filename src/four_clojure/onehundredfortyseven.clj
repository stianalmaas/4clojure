Pascal's Trapezoid
 
Difficulty:	Easy
Topics:	seqs


Write a function that, for any given input vector of numbers, returns an infinite lazy sequence of vectors, where each next one is constructed from the previous following the rules used in Pascal's Triangle. For example, for [3 1 2], the next row is [3 4 3 2].
	
(= (second (__ [2 3 2])) [2 5 5 2])
	
(= (take 5 (__ [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])
	
(= (take 2 (__ [3 1 2])) [[3 1 2] [3 4 3 2]])
	
(= (take 100 (__ [2 4 2])) (rest (take 101 (__ [2 2]))))


(def data [3 1 2])

(partition 2 1 data)

(conj (vec (cons 0 data)) 0)

(conj data 0)

(map #(apply + %) (partition 2 1 data))

(vec (map #(apply + %) (partition 2 1 (conj (vec (cons 0 data)) 0))))

(conj (vec (cons 0 data)) 0)

(into [(first data)]  (map #(apply + %) (partition 2 1 data)) (peek data))


(take 100  (iterate (fn[data](vec (map #(apply +' %) (partition 2 1 (conj (vec (cons 0 data)) 0))))) [2 4 2]))


(fn[c](iterate (fn[data](vec (map #(apply +' %) (partition 2 1 (conj (vec (cons 0 data)) 0))))) c))


darren's solution:
(fn [vs]
  (iterate (fn [v] (map + `(0 ~@v) `(~@v 0))) vs))

amalloy's solution:
iterate #(map +' `(0 ~@%) `(~@% 0))

chouser's solution:
iterate #(map + `(0 ~@%) `(~@% 0))

cgrand's solution:
iterate #(vec (map + (conj % 0) (cons 0 %)))

Tar to kopier av vektoren og legger de sammen etter å ha forskjøvet de et hakk i forhold til hverandre

[2 3 2 0]
[0 2 3 2] +
----------
[2 5 5 2]


