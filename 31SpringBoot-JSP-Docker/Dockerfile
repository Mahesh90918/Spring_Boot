FROM openjdk:11-oracle
EXPOSE 1234
ADD target/docker-with-mysql.war docker-with-mysql.war
ENTRYPOINT ["java","-jar","/docker-with-mysql.war"]