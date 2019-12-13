FROM adoptopenjdk:11-jre-hotspot
LABEL maintainer = marlymazing
VOLUME /tmp
EXPOSE 8443
ARG JAR_FILE=target/commons-csc430-webapp-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} commons-csc430-webapp.jar
EXPOSE 8443
CMD ["java", "-jar", "techware.jar"]
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/commons-csc430-webapp.jar"]
