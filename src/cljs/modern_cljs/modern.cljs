(ns ember-cljs.core
  (:require [clojure.string :as string]
            [jquery] [ember]))

(def Ember js/Ember)
(def HomeRoute
  (.extend (.-Route Ember)
    #js {:model
         (fn []
           "Dynamic Data")}))

(let [application (.create (.-Application Ember))
      router (.-Router application)]
  (set! (.-HomeRoute application) HomeRoute)
  (.map router (fn []
                 (this-as r
                   (.route r "home" #js {:path "/"})
                   (.route r "foo" #js {:path "/foo"})))))
