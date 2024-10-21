
FROM openjdk:21-jdk-slim

COPY target/SoftwareAdmonFotografia-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
