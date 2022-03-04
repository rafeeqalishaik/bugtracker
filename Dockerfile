# define base docker image
FROM openjdk:11
LABEL maintainer="Rafeeq Ali Shaik"
ADD target/bugtracker.jar bugtracker.jar
ENTRYPOINT ["java", "-jar", "bugtracker.jar"]
