(ns hemmvm.clj-workshop.brainfuck.main
  (:require [clojure.java.io :as io]
            [hemmvm.clj-workshop.brainfuck.core :as core])
  (:gen-class))


(defn -main
  [& args]
  (let [file (io/file (first args))]
    (core/run (slurp file))))
