FROM eclipse-temurin:21-jdk
EXPOSE 8081
ADD target/*.jar mavilapos.jar
ENTRYPOINT ["java","-jar","/mavilapos.jar"]