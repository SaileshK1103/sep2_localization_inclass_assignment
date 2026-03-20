# We only need the Runtime (JRE), not the full SDK/Maven, to keep it small
FROM eclipse-temurin:21-jre-alpine

LABEL authors="saileshk"

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR we just built in the Jenkins 'Build' stage
# Ensure this matches the <finalName>CalculatorApp</finalName> in your pom.xml
COPY target/CalculatorApp.jar app.jar

# Run the calculator
# We use ENTRYPOINT so the container starts the app immediately
ENTRYPOINT ["java", "-jar", "app.jar"]