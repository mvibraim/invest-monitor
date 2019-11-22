-- DEV

CREATE ROLE invest_monitor_test CREATEDB NOSUPERUSER NOCREATEROLE LOGIN ENCRYPTED PASSWORD 'invest_monitor_test';
CREATE DATABASE invest_monitor_test WITH ENCODING='UTF8' OWNER=invest_monitor_test;

\connect invest_monitor_test