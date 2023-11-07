FROM maven:3-jdk-8-alpine
ARG SW_VERSION=0.0.1-SNAPSHOT
ARG JAR_FILE=./target/LayeredArchitectureDemo-${SW_VERSION}.jar
COPY ${JAR_FILE} /app.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/app.jar"]