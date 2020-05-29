FROM adoptopenjdk/openjdk8
ADD target/Wastemanagement.jar . 
ENTRYPOINT ["java","-jar", "Wastemanagement.jar"]
