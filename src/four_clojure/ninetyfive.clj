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