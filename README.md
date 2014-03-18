# Seven-Languages-in-Seven-Weeks

My exercise in Seven Languages in Seven Weeks

## [DONE] Ruby

method_missing 非常好用，具体见 ruby/csv

## [DOING] IO

## [TODO] Prolog

## [TODO] Erlang

## [DONE] Clojure

写 Clojure 的话 Lighttable 不错。

repl 可以用 `lein repl`

### 相关的一些东西

- http://stackoverflow.com/questions/9983009/nothing-happen-inside-my-clojure-loop

- http://adambard.com/blog/clojure-concurrency-smorgasbord/

- http://www.blogjava.net/killme2008/category/archive/2010/07/archive/2010/07/14/326027.html

- http://stackoverflow.com/questions/20485188/gracefully-exit-a-clojure-core-async-go-loop-on-kill

### 有意思的包

- core.match (Clojure / ClojureScript)

- core.logic (Clojure / ClojureScript)

  Prolog-like relational programming

- core.async (Clojure / ClojureScript)

  Facilities for async programming and communication in Clojure

  我测试的结果：Java下是能用满所有 CPU，Js下是个状态机，只能吃满一个 CPU。

  顺带一说，ES6 的 Promise 也非常不错，简化了异步的操作。

- algo.monads (Clojure)
