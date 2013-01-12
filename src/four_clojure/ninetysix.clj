Beauty is Symmetry
 
Difficulty:	Easy
Topics:	trees


Let us define a binary tree as "symmetric" if the left half of the tree is the mirror image of the right half of the tree. Write a predicate to determine whether or not a given binary tree is symmetric. (see To Tree, or not to Tree for a reminder on the tree representation we're using).
	

(= (__ '(:a (:b nil nil) (:b nil nil))) true)
	

(= (__ '(:a (:b nil nil) nil)) false)
	

(= (__ '(:a (:b nil nil) (:c nil nil))) false)
	

(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true)
	

(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false)
	

(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false)


(def data '(:a (:b nil nil) (:c nil nil)))
(def data [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
           [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
(def data [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
           [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
(def data [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] nil]] nil]])


(defn mirror [[v t1 t2]]
  [v (if (nil? t2) nil (mirror t2)) (if (nil? t1) nil (mirror t1)) ])

(mirror data)

(defn mirror? [[v t1 t2]]
  (= t1 (mirror t2)))

(mirror? data)

#(let [[v t1 t2] %
       m (fn [ [v t1 t2]] [v (if (nil? t2) nil (mirror t2)) (if (nil? t1) nil (mirror t1)) ])]
   (= t1 (m t2)))


data

(let [[v t1 t2] data]
  [v t2 t1])


logosity's solution:
(fn f [[_ [v x y :as l] [w a b :as r]]]
  (or (= nil l r)
    (and (= v w)
         (f [1 x b])
         (f [1 a y]))))

cgrand's solution:
(fn [[_ a b]]
  (= b ((fn f [[v a b :as t]]
          (and t [v (f b) (f a)])) a)))

abrooks's solution:
(fn [[_ A B]]
  (= A ((fn f [x]
          (when-let [[v a b] x] [v (f b) (f a)]))
        B)))

chouser's solution:
(fn [[_ a b]]
  ((fn m [[c d e] [f g h]]
     (if c
       (and (= c f) (m d h) (m e g))
       true))
     a b))

amcnamara's solution:
#(letfn [(f [c] (if (coll? c)
                  [(% c) (f (%2 c)) (f (%3 c))]
                  c))]
  (= (%3 %4) (f (%2 %4))))
first last second


