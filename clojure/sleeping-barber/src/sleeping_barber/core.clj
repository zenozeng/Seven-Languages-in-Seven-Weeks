(ns sleeping-barber.core)

(require '[clojure.core.async :as async :refer [go chan]])

;; Atoms are an efficient way to represent some state that will never need to be coordinated with any other, and for which you wish to make synchronous changes (unlike agents, which are similarly independent but asynchronous).

(def sum-of-business (atom 0))
(def current-customers (atom 0))

(defn -main
  []

  ;; 理发师
  (go (while true
        (when (> @current-customers 0)
          (Thread/sleep 20) ; 一次理发要 20 毫秒
          (swap! current-customers dec)
          (swap! sum-of-business inc))))

  ;; 随机加入新的顾客
  (go (while true
        (Thread/sleep (+ 10 (rand-int 21)))
        ;; 一个店最多容纳 3 个等待的和 1 个进行中的
        (when (<= @current-customers 4)
          (swap! current-customers inc))))

  (go (while true
        (Thread/sleep (* 10 1000))
        (println "hello")
        (println "10秒营业小结" @sum-of-business)
        (swap! sum-of-business - @sum-of-business)))

  (println "运行100s")
  ;; 必须要 sleep 否则主线程将会被 kill 掉
  (Thread/sleep (* 100 1000)))
