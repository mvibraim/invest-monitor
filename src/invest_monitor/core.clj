(ns invest-monitor.core
  (:gen-class)
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [ring.middleware.reload :as reload]
            [invest-monitor.web.router :as router]))

(defroutes app-routes router/endpoints)

(defn -main
  "This is our app's entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "8080"))
        handler (reload/wrap-reload #'app-routes)]
    (server/run-server handler {:port port})
    (println (str "Server running at http:/127.0.0.1:" port "/"))))