# FROM eclipse-temurin:17-jdk

# WORKDIR /app

# COPY target/patient-cli-1.0-SNAPSHOT-shaded.jar app.jar

# ENTRYPOINT ["java","-jar","app.jar"]
FROM eclipse-temurin:17-jre

WORKDIR /app

COPY target/patient-cli-1.0-SNAPSHOT-shaded.jar app.jar

CMD ["java", "-jar", "app.jar"]