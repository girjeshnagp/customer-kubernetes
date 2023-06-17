FROM gradle:7.6.1-jdk17-alpine AS build
WORKDIR /app
COPY build.gradle .
COPY settings.gradle .
COPY src ./src
RUN gradle build --no-daemon

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
LABEL org.opencontainers.image.title="customer-service"
LABEL org.opencontainers.image.version="1.0.0"

# adding environment variables
ENV POSTGRES_HOST=postgres
ENV POSTGRES_PORT=5432
ENV POSTGRES_DB=mydatabase
ENV POSTGRES_USER=myuser
ENV POSTGRES_PASSWORD=mypassword

ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=local", "app.jar"]
