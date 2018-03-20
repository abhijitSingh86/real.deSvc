# real.deSvc

Extract the source folder, try running " java -jar target/real.deSvc-0.1.0.jar "  as I have attached a pre-packaged solution. If It doesn't work, please follow the steps below
mvn package
java -jar target/real.deSvc-0.1.0.jar 

If mvn not found
install maven 

If mvn fails to detect Java
export JAVA_HOME=/usr/local/jdk1.8.0_152/ 


Use Curl or Postman like utility to fetch a URL
To fetch list of Customer
curl -X GET localhost:8080/customer 

To place an order for Customer
curl -X POST localhost:8080/customer/3/order
