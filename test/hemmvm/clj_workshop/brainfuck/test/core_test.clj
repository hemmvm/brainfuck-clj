(ns hemmvm.clj-workshop.brainfuck.test.core-test
  (:require [clojure.test :refer [deftest is]]
            [clojure.java.io :as io]
            [hemmvm.clj-workshop.brainfuck.core :as core]))


(deftest test-run
  (is (= "Hello World!\n"
         (with-out-str
           (-> (io/resource "hello-comment.bf")
               slurp
               core/run)))))
