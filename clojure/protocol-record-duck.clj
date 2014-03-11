(defprotocol Animal
  (age [c])
  (grow [c]))

(defrecord Duck [age]
  Animal
  (grow [_] (Duck. (inc age))))

(def duck (Duck. 1))
(grow duck) ; 注意这里不是修改原先的变量而是返回了一个全新的实例
duck ; 这里的 duck 还是 1 岁
