(defn collection-type
  "Return the collection type :list :map :vector"
  [col]
  (cond
   (list? col) :list
   (map? col) :map
   (vector? col) :vector
   ))

(collection-type '(1 2 3))
(collection-type {:a 1 :b 2 :c 3})
(collection-type [1 2 3])

