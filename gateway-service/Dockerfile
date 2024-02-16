FROM openjdk:21-jdk

COPY target/*.jar gateway-service.jar

EXPOSE 8222

CMD ["java", "-jar", "/gateway-service.jar"]