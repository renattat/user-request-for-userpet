FROM openjdk:21

WORKDIR /usr/local/bin/

COPY /target/userrequest-0.0.1-SNAPSHOT.jar /usr/local/bin/user-request.jar

CMD ["java","-jar","user-request.jar"]
