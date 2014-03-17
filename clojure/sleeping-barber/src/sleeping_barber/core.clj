(ns sleeping-barber.core)

(require '[clojure.core.async :as async :refer [go chan]])

(defn -main
  []

  (println "Sleeping Barber!")

  (let [customs-count-chan (chan)
        customs-chan (chan)
        sum-of-business (chan)]

    ;; 柜台线程，顾客管理
    (go (while true
          (let [msg (<! customs-chan)
                count (<! customs-count-chan)
                sum (<! sum-of-business)]
            (if (= msg "come")
              (>! customs-count-chan (inc count)))
            (if (= msg "leave")
              (>! customs-count-chan (dec count))
              (>! sum-of-business (inc sum))))))

    ;; 本次营业为10s
    (go (while true
          (println "开始营业")
          (Thread/sleep (* 10 1000))
          (let [sum (<! sum-of-business)]
            (println "结束营业")
            (println "本次营业额：" sum))))
    

    ;; 新顾客线程
    (go (while true
          ;; 每 10 - 30 秒有一个顾客到达理发店
          (Thread/sleep (+ 10 (rand-int 21)))
          (>! customs-chan "come")))

    ;; 理发师线程
    (go (while true
          (let [customs (<! customs-count-chan)]
            (if (> customs 1)
              (do
                (Thread/sleep 20)
                (>! customs-chan "leave"))))))))
