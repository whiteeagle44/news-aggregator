FROM amazoncorretto:17.0.8-alpine3.18
MAINTAINER eagle44.io
COPY build/libs/newsproducer-0.0.1-SNAPSHOT.jar newsproducer-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5000","-jar","/newsproducer-0.0.1-SNAPSHOT.jar"]