FROM openjdk:11-oracle
EXPOSE 8080
ADD target/springboot-docker.jar springboot-docker.jar
ENTRYPOINT ["java","-jar","/springboot-docker.jar"]