(defproject cljsbuild-example-simple "1.0.2"
  :description "A simple example of how to use lein-cljsbuild"
  :source-paths ["src-clj"]
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2014"
                  :exclusions [org.apache.ant/ant]]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.4"]]
  :plugins [[lein-cljsbuild "1.0.2"]
            [lein-ring "0.8.7"]]
  :cljsbuild {
    :builds [{:source-paths ["src"]
              :compiler {:output-to "js/async.js"
                         :optimizations :advanced
                         :pretty-print true}}]})
