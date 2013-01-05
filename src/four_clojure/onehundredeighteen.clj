Re-implement Map
 
Difficulty:	Easy
Topics:	core-seqs


Map is one of the core elements of a functional programming language. Given a function f and an input sequence s, return a lazy sequence of (f x) for each element x in s.

	

(= [3 4 5 6 7]
   (__ inc [2 3 4 5 6]))
	

(= (repeat 10 nil)
   (__ (fn [_] nil) (range 10)))
	

(= [1000000 1000001]
   (->> (__ inc (range))
        (drop (dec 1000000))
        (take 2)))


(def data [2 3 4 5 6])

( (fn m[f c](cons (f (first c)) (lazy-seq (m f (rest c))))) inc data)


(fn m[f c](if (empty? c) [](cons (f (first c)) (lazy-seq (m f (rest c))))))


chouser's solution:
(fn l [f [a & m]]
  (lazy-seq
    (cons (f a) (if m (l f m)))))

devn's solution:
#(rest (reductions (fn [_ x] (% x)) 0 %2))

raynes's solution:
(fn m [f s] (if-let [s (seq s)] (cons (f (first s)) (lazy-seq (m f (next s)))) s))

tormaroe's solution:
(fn map2 [f s]
  (when (seq s)
    (lazy-seq (cons (f (first s))
                    (map2 f (rest s))))))


