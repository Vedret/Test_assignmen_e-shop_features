# Test_assignmen_e-shop_features

The main task of this test assignment is to code an e-shop features.
Let's imagine an e-shop selling watches. The store has a REST service for uploading products
to the e-shop warehouse.
The watch has some basic information (see JSON below) and also information about the
fountain. The fountain is sent as a base64 image.
Example of a fountain watch:
{
"title": "Prim",
"price": "250000", // int
"description": "A watch with a water fountain picture",
"fountain": "R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs="
// base64 picture
}
Task:
#### 1. Create a project using the Spring Framework
Spring Boot project has been created using [Spring Initializr](https://start.spring.io), included dependencies are:
<br/> Spring Web(For RESTfull,MVC,Tomcat etc.),
<br/>Spring Boot Dev Tools(for fast application restart),
<br/>H2 database(In memory database that supports JDBC API), 
<br/>Spring Data JPA.

Manually added dependecies are: 
<br/>Jackson Dataformat XML, 
<br/>Spring Boot Starter Validation(Validation starter is not included in web starters anymore, spring boot 2.3.1 release there is no longer contains spring-boot-starter-validation with spring starter)

#### 2. Prepare Controller and Services which will process the incoming payload and map it to
Created classes:
com.eshop.selling.watches.test.assignment
the pre-prepared model Watch
3. Correctly validate the input and return the error HTTP status code
4. Save the received data to any DB (just save the images to the DB) and return 201
CREATED
5. Prepare the application to change the format of the input data simply, communication
with the e-shop can switch to XML or another format (use request header)
