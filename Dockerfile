FROM openjdk:8-jdk-alpine
COPY "./target/CardsAPI-0.0.1-SNAPSHOT.jar" "app.jar"
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "app.jar"]
