FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY target/*.jar springbootapp.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","springbootapp.jar"] 