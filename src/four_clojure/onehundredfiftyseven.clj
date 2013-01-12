Indexing Sequences
 
Difficulty:	Easy
Topics:	seqs


Transform a sequence into a sequence of pairs containing the original elements along with their index.
	
(= (__ [:a :b :c]) [[:a 0] [:b 1] [:c 2]])
	
(= (__ [0 1 3]) '((0 0) (1 1) (3 2)))
	
(= (__ [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]])



Congratulations, you've solved the problem! See the solutions that the users you follow have submitted, or share this solution on github and twitter! Now you can move on to Decurry, or go back and try Intro to Trampoline again!


(fn[c](map #(list % %2) c (range 9)))


darren's solution:
#(map list % (range))


amcnamara's solution:
#(map-indexed (fn [a b] [b a]) %)


seancorfield's solution:
(partial map-indexed (fn [i x] (vector x i)))


cgrand's solution:
map-indexed #(list %2 %)






