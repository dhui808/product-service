# Product Service
Product Service with Spring Boot and Docker

Set up MySQL database
mysql -u root -p
(Enter password)
create database productdb;
quit

Test with curl:

curl -X POST -d @testdata/register1.json http://localhost:8080/productservice/product/add --header "Content-Type:application/json"

curl -X GET http://localhost:8080/productservice/products --header "Content-Type:application/json"


Swagger doc URL:

http://localhost:8080/productservice/swagger-ui.html

Swagger JSON URL:
http://localhost:8080/productservice/v2/api-docs


