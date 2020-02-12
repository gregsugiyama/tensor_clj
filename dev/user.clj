(ns user
  (:require
   [figwheel.main.api :as fw]
   [taoensso.timbre :as timbre]))

(defn go
  ([]
   (go "dev"))
  ([build-id]
   (timbre/info (str "starting figwheel with build-id \"" build-id "\""))
   (fw/start {:mode :serve} build-id)))

