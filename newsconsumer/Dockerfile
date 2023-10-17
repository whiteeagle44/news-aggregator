FROM amazoncorretto:17.0.8-alpine3.18
MAINTAINER eagle44.io
COPY build/libs/newsconsumer-0.0.1-SNAPSHOT.jar newsconsumer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5001", "-jar","/newsconsumer-0.0.1-SNAPSHOT.jar"]