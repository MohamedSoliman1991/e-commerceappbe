1- Run the executable JAR provided by Spring Boot with embedded Tomcat. java -jar ecomperceappbe-0.0.1-SNAPSHOT.jar

H2 InmemoryDB is used for DBMS.

run testCases using: mvn test jacoco:report

Code Coverage report : HTML report of the code coverage information will be found in the target/site/jacoco directory.

1- Cart service :

URL : http://{SERVERIP}:8081/eshop/cart TYPE: POST Request : {"userId":1, "seletedProducts": [{ "itemId":1, "quantity":"1" }] }

Response : [ { "quantity": 1, "price": 30.0, "itemName": "Tea" } ]

2- GenerateBill :

URL : http://localhost:8081/eshop/bill/{userId} TYPE: GET Request: PathVaribale Response: { "originalAmount": 30.0, "totalBillAmount": 9.0 }
