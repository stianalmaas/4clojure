intoCamelCase
 
Difficulty:	Medium
Topics:	strings


When working with java, you often need to create an object with fieldsLikeThis, but you'd rather work with a hashmap that has :keys-like-this until it's time to convert. Write a function which takes lower-case hyphen-separated strings and converts them to camel-case strings.
	

(= (__ "something") "something")
	

(= (__ "multi-word-key") "multiWordKey")
	

(= (__ "leaveMeAlone") "leaveMeAlone")


(def data "something")
(def data "multi-word-key")


(def split (seq (.split data "-" 0)))

(def word  (str (first split) (map #(apply str (Character/toUpperCase (first %)) (rest %)) (rest split))))

split
data
word

(map #(apply str (Character/toUpperCase (first %)) (rest %)) (rest split))


(apply str (conj (rest ord) (Character/toUpperCase (first ord))))


(map #(apply str (conj (rest %) (Character/toUpperCase (first %)))) split)


(defn cc[s]
  ( let [split (seq (.split s "-" 0))]
    (str (apply str (conj (rest (first split)) (Character/toUpperCase (first (first split))))) (apply str (rest split))))
  )


(defn cc [s]
  (let [split (seq (.split s "-" 0))]
    (str (first split) (apply str (map #(apply str (conj (rest %) (Character/toUpperCase (first %)))) (rest split))))))

(cc data)
(cc "leaveMeAlone")
(cc "something")
(cc "multi-word-key")


(.toUpperCase (.substring "multi" 0 1))

(-> "multi"
    (.substring 0 1)
    .toUpperCase)


(str
 (-> "multi"
    (.substring 0 1)
    .toUpperCase)
 (.substring "multi" 1))


(defn cc [s]
  (let [split (seq (.split s "-" 0))]
    (str (first split) (apply str (map #(str (-> % (.substring 0 1) .toUpperCase) (.substring % 1)) (rest split))))))



amalloy's solution:
(fn [s]
  (clojure.string/replace s
                          #"-(\w)"
                          (comp clojure.string/upper-case
                                second)))

chouser's solution:
#(clojure.string/replace % #"-." (fn [[_ x]] (format "%S" x)))


immo's solution:
#(let [s (clojure.string/split % #"-")]
  (apply str (first s) (map clojure.string/capitalize (rest s))))

bradediger's solution:
#(clojure.string/replace % #"-(\w)" (fn [[_ l]] (.toUpperCase l)))






