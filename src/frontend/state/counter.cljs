(ns frontend.state.counter
  (:require
   [re-frame.core :as re-frame :refer [reg-event-db reg-event-fx reg-sub subscribe]]))

(reg-sub
 ::count
 (fn [db]
   (::count db)))

(reg-event-db
 ::inc-count
 (fn [db _]
   (update db ::count inc)))

(reg-event-db
 ::dec-count
 (fn [db _]
   (update db ::count dec)))
