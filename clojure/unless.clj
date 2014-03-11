;; 关于 macro，可以看看这篇
;; http://blog.csdn.net/ithomer/article/details/17590193

(defmacro unless [test ifnil iftrue]
  `(if ~test ~iftrue ~ifnil))

;; List 实现

(defmacro unless [test ifnil iftrue]
  (list 'if test iftrue ifnil))

(unless false (println "TRUE") (println "FALSE"))
