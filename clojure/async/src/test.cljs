(ns example.hello
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs.core.async :refer [put! chan <! close!]]))

(defn timeout [ms]
  (let [c (chan)]
    (js/setTimeout (fn [] (close! c)) ms)
    c))

(let [ch (chan)]
  (go (while true
        (let [v (<! ch)]
          (js/console.log "Read: " v))))
  (go (>! ch "hi")
      (<! (timeout 5000))
      (>! ch "there")))
