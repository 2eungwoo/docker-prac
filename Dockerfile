FROM openjdk:17
ARG JAR_FILE=build/libs/myapp.jar
COPY ${JAR_FILE} ./myapp.jar
ENV TZ=Asia/Seoul
ENTRYPOINT ["java","-jar","./myapp.jar"]