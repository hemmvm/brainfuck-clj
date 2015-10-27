(ns hemmvm.clj-workshop.brainfuck.test.parser-test
  (:require [clojure.test :refer [deftest are]]
            [hemmvm.clj-workshop.brainfuck.parser :as p]))


(deftest test-parse
  (are [ast tokens] (= ast (p/parse tokens))
    ["+" ">" "."]
    ["+" ">" "."]

    ["+" [ ">" ] "."]
    ["+" "[" ">" "]" "."]

    ["+" "+" "+" "+"
     [">" ">" ">" "+" "+"
      ["<" "<" "+"
       ["-" ">" "+"]]
      "." "."]
     ">" ">"
     ["<"]
     "." "."]

    ["+" "+" "+" "+"
     "[" ">" ">" ">" "+" "+"
     , "[" "<" "<" "+"
     , , "[" "-" ">" "+" "]" "]"
     , "." "." "]"
     ">" ">"
     "[" "<" "]"
     "." "."]))
