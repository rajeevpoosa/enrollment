Enrollee-service
Build Status Coverage Status License

Minimal Spring Boot sample app.

Requirements
For building and running the application you need:

JDK 1.8
Maven 3
Running the application locally
There are several ways to run a Spring Boot application on your local machine. 
One way is to execute the main method in the  com.EnrolleeServiceApplication class from your IDE.

Alternatively you can use the Spring Boot Maven plugin like so:

mvn spring-boot:run

This will create:

An ImageStream called "springboot-maven3-centos"
An ImageStream called "Enrollee-service"
A BuildConfig called "Enrollee-service"
DeploymentConfig called "Enrollee-service"
Service called "Enrollee-service"
