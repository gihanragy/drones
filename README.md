# Drones
Drone Project is Spring boot Java Application, and the build tool is maven <br />
Drone Project are multi lang project<br />
you can specify lang under translation folder<br />
Flyway  used for data migration <br />
Swagger  used for API documentation and Testing<br/>

Due to limited time we don't have chance to create a scheduler to audit drone battery and test cases<br />

the web server port number is 8041 you can change this application.properties<br />
H2 in memory db  used for storing object<br />


#Project Assumption<br />
Drone Models are static as int value<br />
   Lightweight(1),
    Middleweight(2),
    Cruiserweight(3),
    Heavyweight(4)
    
Drone Status as int value<br />
    IDLE(1),
    LOADING(2),
    LOADED(3),
    DELIVERING(4),
    DELIVERED(5),
    RETURNING(6);

#build<br />
mvn clean install
#run<br />
java -jar target/Musala-Drones-backend.jar<br />
#Test API using swagger<br />
http://localhost:8041/swagger-ui.html
#Check the data in H2 DB<br />
http://localhost:8041/h2-console <br />
driver class :org.h2.Driver <br />
JDBC URL :jdbc:h2:mem:testdb  <br />
user name:sa password:sa <br />