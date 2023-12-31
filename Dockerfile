FROM maven:3.8.5-openjdk-17 as build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim
COPY --from=build /target/assignment_2-0.0.1-SNAPSHOT.jar assignment2.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","assignment2.jar"]