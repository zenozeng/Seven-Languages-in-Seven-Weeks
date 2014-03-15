;; Clojure in java will make full use of all my cpus

(ns example.hello)

(require '[clojure.core.async :as async])

(let [c1 (async/chan)
      c2 (async/chan)
      c3 (async/chan)
      c4 (async/chan)]
  (async/go (while true
        (inc 1)))
  (async/go (while true
        (inc 1)))
  (async/go (while true
        (inc 1)))
  (async/go (while true
        (inc 1))))
