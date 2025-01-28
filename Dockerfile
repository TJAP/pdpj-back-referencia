FROM openjdk:11-jre-slim

COPY target/appname.jar /opt/appname/appname.jar

WORKDIR /opt/appname

EXPOSE 8080

ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/appname/appname.jar" ]