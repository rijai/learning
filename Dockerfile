FROM eclipse-temurin:17-jdk-alpine
EXPOSE 8080
VOLUME /tmp
COPY target/mysql-connector-java-8.0.29.jar .
COPY target/omt-server-0.0.1-SNAPSHOT.jar .
ENTRYPOINT ["java","-jar","/omt-server-0.0.1-SNAPSHOT.jar"]
