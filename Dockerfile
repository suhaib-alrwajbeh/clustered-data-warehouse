FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app

COPY ./pom.xml ./pom.xml

# Download the dependency as a separate step to benefit from Docker layer caching.
# This step will be re-executed only if the pom.xml changes.
RUN mvn dependency:go-offline -B

COPY ./src ./src

RUN mvn package -DskipTests

# Use OpenJDK JRE 17 for runtime
FROM openjdk:17

# Set the working directory to /app
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/*.jar clustered-data-warehouse-app.jar

# Specify the entrypoint to run your application
ENTRYPOINT ["java", "-jar", "clustered-data-warehouse-app.jar"]
