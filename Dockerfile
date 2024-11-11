From eclipse-temurin:21.0.5_11-jdk

EXPOSE 8080

WORKDIR /app

COPY ./pom.xml/app
COPY ./.mvn/app/.mvn
COPY ./mvnw/app

RUN  ./mvnw dependency:go-offline

COPY ./src/app/src

RUN ./mvnw clean install -DskipTest

ENTRYPOINT["java","-jar","/app/target/api-0.0.1-SNAPSHOT.jar"]