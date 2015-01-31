(ns ember-cljs.core
  (:require [clojure.string :as string]
            [jquery] [ember]))

(def Ember js/Ember)
(def HomeRoute
  (.extend (.-Route Ember)
    #js {:model
         (fn []
           "Dynamic Data")}))

(def SmallComponentComponent
  (.extend (.-Component Ember)
    #js {:dynamicAttribute "foo"
         :thing "123"
         :actions
         #js {:myAction
              (fn []
                (this-as this
                 (.set this "dynamicAttribute" "abc")))}}))

(let [application (.create (.-Application Ember))
      router (.-Router application)]
  (set! (.-HomeRoute application) HomeRoute)
  (set! (.-SmallComponentComponent application) SmallComponentComponent)
  (.map router (fn []
                 (this-as r
                   (.route r "home" #js {:path "/"})
                   (.route r "foo" #js {:path "/foo"})))))
