(defproject re.blacksqua/saddle-point "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "The MIT License"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot saddle-point.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
