FROM openjdk:17
LABEL maintainer="com.Springboot"
ADD target/SpringHospitalProject-0.0.1-SNAPSHOT.jar SpringHospitalProject.jar
ENTRYPOINT ["java","-jar","SpringHospitalProject.jar" ]
