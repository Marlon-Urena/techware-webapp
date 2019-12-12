FROM azul/zulu-openjdk-alpine:8
VOLUME /tmp
EXPOSE 8080
COPY target/commons-csc430-webapp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /app.jar