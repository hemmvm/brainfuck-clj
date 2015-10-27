(ns hemmvm.clj-workshop.brainfuck.test.lexer-test
  (:require [clojure.test :refer [deftest are]]
            [clojure.java.io :as io]
            [hemmvm.clj-workshop.brainfuck.lexer :as l]))


(deftest test-scan
  (are [tokens string] (= tokens (l/scan string))
    ["-" "+" "." "," ">" "<" "[" "]"]
    "-+.,><[]"

    ["-" "+" "." "," ">" "<" "[" "]"]
    "\nabc-  +.,>\n\n<[xxx]"

    ["[" "." "." "." "," "." "[" "." "]" "," "." "." "," "," "," "+" "," "-" "," "<"
     ">" "," "[" "]" "." "." "]" "+" "+" "+" "+" "+" "+" "+" "+" "[" ">" "+" "+" "+"
     "+" "[" ">" "+" "+" ">" "+" "+" "+" ">" "+" "+" "+" ">" "+" "<" "<" "<" "<" "-"
     "]" ">" "+" ">" "+" ">" "-" ">" ">" "+" "[" "<" "]" "<" "-" "]" ">" ">" "." ">"
     "-" "-" "-" "." "+" "+" "+" "+" "+" "+" "+" "." "." "+" "+" "+" "." ">" ">" "."
     "<" "-" "." "<" "." "+" "+" "+" "." "-" "-" "-" "-" "-" "-" "." "-" "-" "-" "-"
     "-" "-" "-" "-" "." ">" ">" "+" "." ">" "+" "+" "."]
    (slurp (io/resource "hello-comment.bf"))
    ))
