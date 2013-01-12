(ns fourclojure.77)

;; Anagram Finder
 
;; Difficulty:	Medium
;; Topics:	


;; Write a function which finds all the anagrams in a vector of words. A word x is an anagram of word y if all the letters in x can be rearranged in a different order to form y. Your function should return a set of sets, where each sub-set is a group of words which are anagrams of each other. Each sub-set should have at least two words. Words without any anagrams should not be included in the result.
	
;; (= (__ ["meat" "mat" "team" "mate" "eat"])
;;    #{#{"meat" "team" "mate"}})          
	
;; (= (__ ["veer" "lake" "item" "kale" "mite" "ever"])
;;    #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})


(def data ["meat" "mat" "team" "mate" "eat"])

(doc group-by)

(filter #(> (count %) 1) (set (vals (group-by #(sort %) data))))

(map #(set %) (vals (group-by #(sort %) data)))

(filter #(> (count %) 1)  (map #(set %) (vals (group-by #(sort %) data))))

(set  (filter #(> (count %) 1)  (map #(set %) (vals (group-by #(sort %) data)))))


(doc for)

(for [v (vals (group-by #(sort %) data)) :while (> (count v) 1)] (set v))


(set (for [v (vals (group-by #(sort %) data)) :while (> (count v) 1)] (set v)))

( ( fn [s] (set (for [v (vals (group-by #(sort %) s)) :while (> (count v) 1)] (set v)))) data)




;; darren's solution:
(fn [s] (set (keep #(if (next %) (set %)) (vals (group-by sort s)))))

;; amalloy's solution

#(set
  (map (comp set val)
       (remove (comp #{1} count val)
               (group-by frequencies %))))


;; chouser's solution:
#(set (for [[_ g] (group-by frequencies %)
            :when (next g)]
        (set g)))


;; cgrand's solution:
#(->> % (group-by sort) vals (filter next) (map set) set)


(doc frequencies)

(group-by frequencies data)

