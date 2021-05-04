FROM adoptopenjdk/openjdk11:latest

EXPOSE 8080

COPY ./target/country-phone-numbers-be-0.0.1-SNAPSHOT.jar country-phone-numbers-be-0.0.1-SNAPSHOT.jar 

RUN sh -c 'touch country-phone-numbers-be-0.0.1-SNAPSHOT.jar'

ENV JAVA_OPTS="" 

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /country-phone-numbers-be-0.0.1-SNAPSHOT.jar" ]
