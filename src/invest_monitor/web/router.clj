(ns invest-monitor.web.router
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [invest-monitor.web.controllers.authentication :as authentication-controller]))

(defroutes endpoints
  (POST "/login" [] authentication-controller/login)
  (route/not-found "Not Found"))