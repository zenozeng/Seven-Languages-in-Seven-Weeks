(require '[clojure.core.async :as async :refer :all])

(let [ch (chan)]
  (go (while true
        (let [v (<! ch)]
          (println "Read: " v))))
  (go (>! ch "hi")
      (<! (timeout 5000))
      (>! ch "there")))
