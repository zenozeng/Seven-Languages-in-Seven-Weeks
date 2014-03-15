;;; Requrie

(ns example.hello
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs.core.async :refer [put! chan <! close!]]))

(defn timeout [ms]
  (let [c (chan)]
    (js/setTimeout (fn [] (close! c)) ms)
    c))

;;; Code Start Here

;; (let [ch (chan)]
;;   (go (while true
;;         (let [v (<! ch)]
;;           (js/console.log "Read: " v))))
;;   (go (>! ch "hi")
;;       (<! (timeout 5000))
;;       (>! ch "there")))

;; CPU Test
;; Seems that clojurescript could only use 100% of one of my cpus

(let [c1 (chan)
      c2 (chan)
      c3 (chan)
      c4 (chan)]
  (go (while true
        (inc 1)))
  (go (while true
        (inc 1)))
  (go (while true
        (inc 1)))
  (go (while true
        (inc 1))))
