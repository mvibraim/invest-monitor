FROM clojure:openjdk-8-lein-2.9.1-slim-buster

RUN mkdir -p /usr/src/app

WORKDIR /usr/src/app

COPY project.clj /usr/src/app/

RUN lein deps

COPY . /usr/src/app

EXPOSE 3000

CMD ["lein", "run"]

# FROM openjdk:8-alpine

# COPY target/uberjar/invest-monitor.jar /invest-monitor/app.jar

# CMD ["java", "-jar", "/invest-monitor/app.jar"]