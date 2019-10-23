# restassured-cucumber
API Framework designed using rest-assured and cucumber in JAVA

# Task: Automate test scenarios for Create Bookings, Get All Bookings, Get Booking using booking id, Update bookings and Delete Bookings API

##Framework Development Environment:
Framework is developed considering following system requirements
- OS - Windos 10/MacOS Mojave 10.14.6	
- Java Version - 1.8.0_211
- IDE - Eclipse Neon.3 Release (4.6.3)
- Maven Version - Apache Maven 3.6.2
- Rest-Assured version - 4.1.2

##Framework Features:
- Framework is designed using Rest-Assured and CucumberV4 in JAVA.
- Implementation of tests is segregated from the tests using Step methods and step definitions.
- Used reporting-plugin of cucumber to generate the Cucumber reports. Also, screenshot is attached in the report itself in case of failure.
- Base URL path is mentioned in configurations.properties which can be changed to use any other url.
- Random data is generated using javafaker where we generated account creation data.
- Response of create booking api is getting stored in response.properties file to validate the response of other APIs.
- createBooking, getBookings and getBooking APIs are automated

##How to RUN:
There are two ways to execute it
First Way:
- Import project into IDE Eclipse as maven project. Cucumber plugin should be present in eclipse.
- Right click on TestRunner.java file and you will get option to RUN as JUNIT Test. Click on it and it will start execution.
- Result can be found in target/cucumber/cucumber-html-reports. Click on overview-features.html and you will see results.
- You may need to do refresh after run to see latest cucumber report
   
Second Way:
- **Maven should be installed in the machine and path needs to be set if not.
- Go to command prompt.
- Run the following command where pom.xml resides.
- **mvn clean test  - it will run all the features available in features folder.


##Future Enhancement: 
- Implementation to store or fetch the response from JSON file to validate the response.
- Implement exception handling
- Implement logs support in the framework
- Passing the response of one api to another when there is multiple API helper classes
- Logging feature for easy debugging 
- Implementing Update and Delete APIs.
