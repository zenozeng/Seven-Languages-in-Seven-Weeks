;; 利用惰性求值实现的 fib 求法
;; 非常快

(defn fib [n]

  (defn fib-pair [[a b]]
    [b (+ a b)])

  (nth (map first (iterate fib-pair [1 1]))
       (+ n 1)))

(fib 400)
