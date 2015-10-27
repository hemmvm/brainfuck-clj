(ns hemmvm.clj-workshop.brainfuck.lexer
  (:require [clojure.string :as str]))


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Helper

(defn strip
  [s]
  (str/replace s #"[^-+.,><\[\]]" ""))

(def tokenize
  (partial map str))


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Scan program

(def scan
  (comp tokenize
        strip))
