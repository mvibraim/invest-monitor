(ns invest-monitor.test.db.core
  (:require
   [invest-monitor.db.core :refer [*db*] :as db]
   [luminus-migrations.core :as migrations]
   [clojure.test :refer :all]
   [clojure.java.jdbc :as jdbc]
   [invest-monitor.config :refer [env]]
   [mount.core :as mount]))

(use-fixtures
  :once
  (fn [f]
    (mount/start
     #'invest-monitor.config/env
     #'invest-monitor.db.core/*db*)
    (migrations/migrate ["migrate"] (select-keys env [:database-url]))
    (f)))

(deftest test-users
  (jdbc/with-db-transaction [t-conn *db*]
    (jdbc/db-set-rollback-only! t-conn)
    (is (= 1 (db/create-user!
              t-conn
              {:cpf         "1234567"
               :pass       "pass"})))
    (is (= {:cpf         "1234567"
            :pass       "pass"}
           (db/get-user t-conn {:cpf "1234567"})))))
