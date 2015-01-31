(defproject modern-cljs "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2740"]
                 [compojure "1.3.1"]]

  ;; CLJ AND CLJS source paths
  :source-paths ["src/clj" "src/cljs"]

  ;; lein-cljsbuild plugin to build a CLJS project
  :plugins [[lein-cljsbuild "1.0.4"]
            [lein-ring "0.9.1"]]

  :ring {:handler modern-cljs.core/handler}
  ;; cljsbuild options configuration
  :cljsbuild {
     :builds [{
       ;; CLJS source path
       :source-paths ["src/cljs"]

       ;; Google Closure (CLS) options configuration
       :compiler {;; CLS generated JS filename
                  :output-to "resources/public/js/modern.js"

                  ;; minimal js optimization
                  :optimizations :whitespace

                  :pretty-print true}}]})

