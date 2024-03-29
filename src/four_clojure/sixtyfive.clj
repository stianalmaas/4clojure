

Black Box TestingSolutions
Difficulty:	Medium
Topics:	seqs testing


Clojure has many sequence types, which act in subtly different ways. The core functions typically convert them into a uniform "sequence" type and work with them that way, but it can be important to understand the behavioral and performance differences so that you know which kind is appropriate for your application.

Write a function which takes a collection and returns one of :map, :set, :list, or :vector - describing the type of collection it was given.
You won't be allowed to inspect their class or use the built-in predicates like list? - the point is to poke at them and understand their behavior.
	
(= :map (__ {:a 1, :b 2}))
	
(= :list (__ (range (rand-int 20))))
	
(= :vector (__ [1 2 3 4 5 6]))
	
(= :set (__ #{10 (rand-int 5)}))
	
(= [:map :set :vector :list] (map __ [{} #{} [] ()]))


(def data [1 2 3 4])

;; My solution
#(if (associative? %)
    (if (reversible? %) :vector :map)
    (if (apply distinct? (conj (conj % 7) 7)) :set :list)
    )



;; darren's solution:
#(let [t (conj % [:a :b] [1 2])]
   (cond (contains? t [:a :b]) :set
         (= (get t :a) :b) :map
         (= (last t) [1 2]) :vector
         :e :list))


;; chouser's solution:
#((zipmap (map str [{} #{} () []]) [:map :set :list :vector]) (str (empty %)))


;; seancorfield's solution:
#(let [z [::test ::val]
  x (conj % z)
y (conj x [::foo ::bar])]
(cond
  (= (::test x) ::val) :map
  (= (count x) (count (conj x z))) :set
(= (first y) [::foo ::bar]) :list
:else :vector))



cgrand's solution:
#(or ({{} :map #{} :set} (empty %))
({1 :vector} (first (conj (empty %) 1 2)) :list))


