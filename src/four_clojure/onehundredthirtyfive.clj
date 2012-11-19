(ns fourclojure.135)

;; Your friend Joe is always whining about Lisps using the prefix notation for math. Show him how you could easily write a function that does math using the infix notation. Is your favorite language that flexible, Joe? Write a function that accepts a variable length mathematical expression consisting of numbers and the operations +, -, *, and /. Assume a simple calculator that does not do precedence and instead just calculates left to right.
	
(= 7  (__ 2 + 5))
	
(= 42 (__ 38 + 48 - 2 / 2))
	
(= 8  (__ 10 / 2 - 1 * 2))
	
(= 72 (__ 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))



(def tall [38 + 48 - 2 / 2])

(def ops  (partition 2 (rest tall)))


(loop [[f n] ops](println f))

(loop [op ops](println (first op))(if (empty? (rest op)) (first op) (recur (rest op))))

(loop [op ops
       acc 38]
  (println (first op))
  (if (empty? op)
    acc
    (recur (rest op) ((first (first op)) acc (second (first op))))))


(loop [op ops
       acc 38]
  (let [[f v] op]
    (if (empty? op)
      acc
      (recur (rest op) (f acc v)))))

(set! *print-length* 103)

(set! *print-level* 15)


; darren's solution:
(fn infix [x op y & more]
  (if more
    (apply infix (cons (op x y) more))
    (op x y)))


; chouser's solution:
(fn f
  ([a] a)
  ([a b c & m]
   (apply f (b a c) m)))


; cgrand's solution:
(fn [x & xs]
  (reduce (fn [x [f y]] (f x y)) x
    (partition 2 xs)))


