FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 6060
ADD target/Kleverness-0.0.1-SNAPSHOT.jar appkleverness.jar
ENTRYPOINT [ "java", "-jar", "/appkleverness.jar" ]