(ns hemmvm.clj-workshop.brainfuck.parser
  (:require [clojure.zip :as zip]))


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Push token onto "AST"

(defmulti push
  (fn [loc token]
    token))

(defmethod push :default
  [loc token]
  (zip/append-child loc token))

(defmethod push "["
  [loc _]
  (-> loc
      (zip/append-child [])
      (zip/down)
      (zip/rightmost)))

(defmethod push "]"
  [loc _]
  (zip/up loc))


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Parse tokens

(defn parse
  [tokens]
  (->> tokens
       (reduce push (zip/vector-zip []))
       (zip/root)))
