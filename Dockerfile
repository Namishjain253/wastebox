FROM adoptopenjdk/openjdk8
ADD skillassure-wastebox-restapi/target/skillassure-wastebox-restapi-0.0.1-SNAPSHOT.jar/ . 
ENTRYPOINT ["java","-jar", "skillassure-wastebox-restapi-0.0.1-SNAPSHOT.jar"]
