(ns frontend.core
  (:require
   [frontend.views.core]
   [re-frame.core :as re-frame]
   [frontend.state.core]
   [reagent.core :as reagent]
   [stylefy.core :as stylefy]
   [taoensso.timbre :as timbre]
   [taoensso.tufte :as tufte]))

(enable-console-print!)

(defonce initializing? (atom true))

(defn mount-root
  []
  (when @initializing?
    (if js/goog.DEBUG
      (do
        (timbre/set-level! :info)
        (tufte/add-basic-println-handler! {}))
      (timbre/set-level! :warn))
    (re-frame/clear-subscription-cache!)
    (re-frame/dispatch-sync [:frontend.state.core/boot])
    (stylefy/init)
    (reset! initializing? false))
  (when-let [dom-root (.getElementById js/document "app")]
    (reagent/render [frontend.views.core/Root] dom-root)))

(mount-root)


