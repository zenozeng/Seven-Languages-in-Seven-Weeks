(def accounts '({:name "Tom" :amount 100}
                {:name "Bob" :amount 100}))

(print accounts)

(defn credit
  "存入"
  [name amount]
  (def accounts (map (fn [account]
                       (if (= (account :name) name)
                         {:name name :amount (+ amount (account :amount))}
                         account
                         )) accounts)))

(defn debit
  "借出"
  [name amount]
  (credit name (- amount)))


(debit "Tom" 50)
(credit "Bob" 100)

(print accounts)
  
