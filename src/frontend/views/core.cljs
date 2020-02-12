(ns frontend.views.core
  (:require
   [frontend.views.helpers :refer [body]]
   [frontend.views.counter :refer [Counter]]))

(defn Root
  []
  [:div {:class-name body}
   [Counter]])

