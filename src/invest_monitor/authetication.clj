(ns invest-monitor.authetication
  (:require [cheshire.core :refer :all]))

(defn login [req]
  {:status  200
   :headers {"Content-Type" "text/json"}
   :body    (generate-string {"Spongebob Narrator" "5 years later..."})})
