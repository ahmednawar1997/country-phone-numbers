FROM openjdk:11-jdk-alpine
MAINTAINER baeldung.com
COPY target/exec.jar exec.jar
ENTRYPOINT ["java","-jar","/exec.jar"]s