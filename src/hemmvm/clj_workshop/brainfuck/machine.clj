(ns hemmvm.clj-workshop.brainfuck.machine
  (:refer-clojure :exclude [eval])
  (:import [jline.console ConsoleReader]))

(declare run)


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Helper

(defn dispatch
  [m inst]
  (if (vector? inst)
    :loop inst))

(defn loop?
  [m]
  (pos? (get-in m [:mem (:mp m)] 0)))


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Eval instruction

(defmulti eval
  dispatch)

(defmethod eval ">"
  [m _]
  (update m :mp inc))

(defmethod eval "<"
  [m _]
  (update m :mp dec))

(defmethod eval "+"
  [m _]
  (update-in m [:mem (:mp m)] (fnil inc 0)))

(defmethod eval "-"
  [m _]
  (update-in m [:mem (:mp m)] (fnil dec 0)))

(defmethod eval ","
  [m _]
  (->> (.readCharacter (ConsoleReader.))
       (assoc-in m [:mem (:mp m)])))

(defmethod eval "."
  [m _]
  (print (str (char (get-in m [:mem (:mp m)]))))
  (flush)
  m)

(defmethod eval :loop
  [m insts]
  (if-not (loop? m)
    m
    (-> (assoc m :ip 0)
        (run insts)
        (assoc :ip (:ip m)))))


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Move instruction pointer

(defmulti move-ip
  dispatch)

(defmethod move-ip :default
  [m _]
  (update m :ip inc))

(defmethod move-ip :loop
  [m _]
  (if (loop? m)
    m
    (update m :ip inc)))


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Run instructions

(defn run
  [m insts]
  (loop [m m]
    (if-let [inst (nth insts (:ip m) nil)]
      (-> m
          (eval inst)
          (move-ip inst)
          (recur))
      m)))


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Machine

(defn new-machine
  []
  {:ip 0
   :mp 0
   :mem {}})
