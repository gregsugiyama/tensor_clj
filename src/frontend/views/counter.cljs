(ns frontend.views.counter
  (:require
   [frontend.state.counter :as cs]
   [frontend.views.helpers :as h]
   [re-frame.core :refer [dispatch subscribe]]
   [stylefy.core :refer [use-style]]))

(defn Counter
  []
  (let [*count (subscribe [:frontend.state.counter/count])]
    [:section {:class-name h/_counter-section}
     [:div {:class-name h/_counter}
      [:article {:class-name h/_counter-article}
       [:h1 {:class-name h/h1} "Current Count: " @*count]
       [:div {:class-name h/_button-row}
        [:a {:class-name h/_button-sm
             :on-click #(dispatch [:frontend.state.counter/inc-count])} "Inc"]
        [:a {:class-name h/_button-sm
             :on-click #(dispatch [:frontend.state.counter/dec-count])} "Dec"]]]]]))
