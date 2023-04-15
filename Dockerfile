FROM openjdk:17-jdk-slim-buster as build

WORKDIR /opt

ADD . .

RUN ./gradlew build --no-daemon

FROM openjdk:17-jdk-slim-buster

RUN mkdir /app

COPY --from=build /opt/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java",  "-XX:InitialRAMPercentage=40.0", "-XX:MaxRAMPercentage=75.0", "-jar", "/app/spring-boot-application.jar"]
