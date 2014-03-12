;; Clojure 用了 STM（软件事务内存）来做并发
;; ref 的状态只能在事务内进行修改

;; TODO： 目前这个实现有问题
;; 输出是： 本次营业共计理发 0 位顾客
;; See: https://gist.github.com/search?l=clojure&q=sleeping+barber


(def 座位 3)
(def 顾客 (ref 0))
(def 顾客计数 (ref 0))
(def 营业时长 (* 10 1000))
(def 理发师在休息 (ref true))

(defn 新顾客
  []
  (dosync
   (if (< @顾客 座位)
     (alter @顾客 (inc @顾客)))
   (when @理发师在休息
     (起来理发))))

(defn 打烊
  "停止营业"
  []
  (dosync
   (println (str "打烊了"))
   (println (str "本次营业共计理发 " @顾客计数 " 位顾客"))
   (System/exit 0) ; 终止程序
  ))

(defn 休息
  []
  (dosync
   (alter @理发师在休息 true)))

(defn 起来理发
  "理发这需要 20ms"
  []
  (dosync
   (alter @理发师在休息 nil)
   (when (> @顾客 0)
     (alter @顾客 (- @顾客 1))
     (Thread/sleep 20))
   (if (> @顾客 0)
     (起来理发)
     (休息))
   ))

(do
  (future
    ;; 每 10 - 30 秒有一个顾客到达理发店
    (Thread/sleep (+ 10 (rand-int 0 21)))
    (新顾客))
  (future
    (起来理发))
  (future
    (Thread/sleep 营业时长)
    (打烊)))
