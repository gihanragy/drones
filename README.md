# Drones
Drone Project is Spring boot Java Application, and the build tool is maven <br />
Drone Project are multi lang project<br />
you can specify lang under translation folder<br />
Flyway  used for data migration <br />
Swagger  used for API documentation and Testing<br/>

Due to limited time we don't have chance to create a scheduler to audit drone battery and test cases

the web server port number is 8041 you can change this application.properties
H2 in memory db  used for storing object


#Project Assumption
Drone Models are static as int value
   Lightweight(1),
    Middleweight(2),
    Cruiserweight(3),
    Heavyweight(4)
#build
mvn clean install
#run
java -jar target/Musala-Drones-backend.jar
#Test API using swagger
http://localhost:8041/swagger-ui.html
#Check the data in H2 DB
http://localhost:8041/h2-console <br />
driver class :org.h2.Driver <br />
JDBC URL :jdbc:h2:mem:testdb  <br />
user name:sa password:sa <br />