(ns invest-monitor.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init
   (fn []
     (log/info "\n-=[invest-monitor started successfully]=-"))
   :stop
   (fn []
     (log/info "\n-=[invest-monitor has shut down successfully]=-"))
   :middleware identity})
