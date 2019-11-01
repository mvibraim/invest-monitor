-- DEV

CREATE ROLE invest_monitor_dev CREATEDB NOSUPERUSER NOCREATEROLE LOGIN ENCRYPTED PASSWORD 'invest_monitor_dev';
CREATE DATABASE invest_monitor_dev WITH ENCODING='UTF8' OWNER=invest_monitor_dev;

\connect invest_monitor_dev