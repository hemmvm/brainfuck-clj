(ns hemmvm.clj-workshop.brainfuck.core
  (:require [hemmvm.clj-workshop.brainfuck.lexer :as l]
            [hemmvm.clj-workshop.brainfuck.parser :as p]
            [hemmvm.clj-workshop.brainfuck.machine :as m]))


(defn run
  [s]
  (->> (l/scan s)
       (p/parse)
       (m/run (m/new-machine))))
