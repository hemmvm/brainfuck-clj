(defproject hemmvm/brainfuck-clj "0.1.0-SNAPSHOT"
  :description "Brainfuck Interpreter (Workshop)"
  :url "https://github.com/hemmvm/brainfuck-clj"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}

  :main hemmvm.clj-workshop.brainfuck.main

  :uberjar-name "brainfuck.jar"

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [jline "2.11"]]

  :profiles {:uberjar
             {:aot :all}

             :dev
             {:dependencies [[org.clojure/tools.namespace "0.2.11"]]}})
