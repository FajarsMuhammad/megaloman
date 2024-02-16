FROM openjdk:21-jdk

COPY target/*.jar discovery-service.jar

EXPOSE 8761

CMD ["java", "-jar", "/discovery-service.jar"]