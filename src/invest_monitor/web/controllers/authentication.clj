(ns invest-monitor.web.controllers.authentication
  (:require [cheshire.core :refer :all]
            [invest-monitor.domain.authentication :as authentication-domain]))

(defn login [req]
  {:status  200
   :headers {"Content-Type" "text/json"}
   :body    (generate-string (authentication-domain/login))})
