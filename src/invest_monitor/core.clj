(ns invest-monitor.core
  (:gen-class)
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.reload :as reload]))

(defn fps-handler [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Pew pew!"})

(defn mail-man []
  "{\"Spongebob Narrator\": \"5 years later...\"}")

(defn mail-handler [req]
  {:status  200
   :headers {"Content-Type" "text/json"}
   :body    (mail-man)})

(defn general-handler [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "All hail General Zod!"})

(defroutes app-routes
  (GET "/" [] fps-handler)
  (POST "/postoffice" [] mail-handler)
  (ANY "/anything-goes" [] general-handler)
  (route/not-found "You Must Be New Here"))

(defn -main
  "This is our app's entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "8080"))
        handler (reload/wrap-reload #'app-routes)]
    (server/run-server handler {:port port})
    (println (str "Server running at http:/127.0.0.1:" port "/"))))