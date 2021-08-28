FROM maven:3-jdk-8-alpine

# Add your instructions to dockerize the application
# App must run on port 8000
FROM openjdk:8
COPY auth_api/target/auth-api-1.0-SNAPSHOT-jar-with-dependencies.jar /home/sre-bootcamp-app.jar
EXPOSE 8000
CMD ["java","-jar","/home/sre-bootcamp-app.jar"]
