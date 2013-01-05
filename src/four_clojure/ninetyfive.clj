(ns fourclojure.95)

; To Tree, or not to Tree
 
; Difficulty:	Easy
; Topics:	trees


; Write a predicate which checks whether or not a given sequence represents a binary tree. Each node in the tree must have a value, a left child, and a right child.
	
;; (= (__ '(:a (:b nil nil) nil))
;;    true)
	
;; (= (__ '(:a (:b nil nil)))
;;    false)
	
;; (= (__ [1 nil [2 [3 nil nil] [4 nil nil]]])
;;    true)
	
;; (= (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]])
;;    false)
	
;; (= (__ [1 [2 [3 [4 nil nil] nil] nil] nil])
;;    true)
	
;; (= (__ [1 [2 [3 [4 false nil] nil] nil] nil])
;;    false)
	
;; (= (__ '(:a nil ()))
;;    false)


(def tre '(:a (:b nil nil) nil))
(def tre '(:a (:b nil nil)))
(def tre [1 nil [2 [3 nil nil] [4 nil nil]]])
(def tre [1 [2 nil nil] [3 nil nil] [4 nil nil]])
(def tre [1 [2 [3 [4 nil nil] nil] nil] nil])
(def tre [1 [2 [3 [4 false nil] nil] nil] nil])
(def tre '(:a nil ()))

(defn tree? [[v t1 t2 & more]]
  (if (and v (or (nil? t1) ( tree? t1)) (or (nil? t2) ( tree? t2)) (empty? more))
    true
    false))


(defn tree? [t]
  (let [[v t1 t2] t]
    (if (or (nil? t) (and v (and (sequential? t1) (sequential? t2)) (= 3 (count t))  (tree? t1) (tree? t2)))
      true
      false)))


(defn tree?[t](and 
  (sequential? t)
  (= (count t) 3)
  (not (nil? (first t)))
  (or (tree? (nth t 1)) (nil? (nth t 1)))
  (or (tree? (nth t 2)) (nil? (nth t 2)))
))


darren's solution:
(fn b [s]
  (if (sequential? s)
    (and (= (count s) 3) (b (fnext s)) (b (fnext (next s))))
    (nil? s)))


amcnamara's solution:
#(odd? (count (filter % (flatten %2))))
#(not (false? %))

mrbliss's solution:
(fn t [x]
  (or (nil? x) (and (sequential? x) (= 3 (count x)) (t (second x)) (t (nth x 2))) false))


chouser's solution:
(fn f [t] (if (coll? t)
(let [[_ a b] t]
(and (= 3 (count t)) (f a) (f b)))
(nil? t)))


cgrand's solution:
(fn f [t]
  (or (nil? t)
    (and (coll? t) (= 3 (count t))
         (every? f (next t)))))


bradediger's solution:
(fn [t] (every? #(or (nil? %) (and (sequential? %) (= (count %) 3)))
  (tree-seq sequential? rest t)))




