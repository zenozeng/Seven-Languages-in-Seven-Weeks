(defmacro unless [test ifnil iftrue]
  `(if ~test ~iftrue ~ifnil))

(unless false (println "TRUE") (println "FALSE"))
