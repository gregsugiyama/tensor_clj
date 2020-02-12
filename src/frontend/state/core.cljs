(ns frontend.state.core
  (:require
   [day8.re-frame.async-flow-fx]
   [re-frame.core :as re-frame :refer [reg-event-db reg-event-fx reg-sub subscribe]]))

(def default-db
  {:frontend.state.counter/count 0})

(defn boot-flow
  []
  {:first-dispatch [::initialize-db]
   :rules
   [{:when :seen?
     :events [::initialize-db]
     :dispatch-n [] ;; add more startup events here
     :halt? true}]})

(reg-event-fx
 ::boot
 (fn [_ _]
   {:async-flow (boot-flow)}))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   default-db))
