FROM openjdk:17
LABEL MAINTAINER=smallintro.github.com
# RUN addgroup -S spring && adduser -S spring -G spring
# USER spring:spring
# WORKDIR /home/spring/
# RUN mkdir -p /home/spring/logs
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} product-service-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","product-service-1.0.0.jar"]
