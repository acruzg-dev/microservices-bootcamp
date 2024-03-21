#inicia con la imagen base que contiene Java runtime
FROM openjdk:17-jdk-slim as build

VOLUME /tmp

# se agregar el jar del microservicio al contenedor
COPY target/ms-eureka-server-0.0.1-SNAPSHOT.jar ms-eureka-server-0.0.1-SNAPSHOT.jar

#se ejecuta el microservicio
ENTRYPOINT ["java","-jar","/ms-eureka-server-0.0.1-SNAPSHOT.jar"]