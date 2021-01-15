# Test_assignmen_e-shop_features

The main task of this test assignment is to code an e-shop features.
<br/>Let's imagine an e-shop selling watches. The store has a REST service for uploading products
to the e-shop warehouse.
<br/>The watch has some basic information (see JSON below) and also information about the
fountain. The fountain is sent as a base64 image.
<br/>Example of a fountain watch:
```
{
"title": "Prim",
"price": "250000", // int
"description": "A watch with a water fountain picture",
"fountain": "R0lGODlhAQABAIAAAAUEBAAAACwAAAAAAQABAAACAkQBADs="
// base64 picture
}
```
Tasks:
#### 1. Create a project using the Spring Framework
Spring Boot project has been created using [Spring Initializr](https://start.spring.io), included dependencies are:
<br/> Spring Web(For RESTfull,MVC,Tomcat etc.),
<br/>Spring Boot Dev Tools(for fast application restart),
<br/>H2 database(In memory database that supports JDBC API), 
<br/>Spring Data JPA.

Manually added dependecies are: 
<br/>Jackson Dataformat XML, 
<br/>Spring Boot Starter Validation(Validation starter is not included in web starters anymore, spring boot 2.3.1 release there is no longer contains spring-boot-starter-validation with spring starter)

#### 2. Prepare Controller and Services which will process the incoming payload and map it to the pre-prepared model Watch
<pre>
<br/>src/main/java
<br/>-com.eshop.selling.watches.test.assignment
<br/> --TestAssignmentApplication.java
<br/>-com.eshop.selling.watches.test.assignment.controller
<br/> --WatchController.java
<br/>-com.eshop.selling.watches.test.assignment.dao
<br/> --WatchDao.java
<br/>-com.eshop.selling.watches.test.assignment.entity
<br/> --Watch.java
<br/>-com.eshop.selling.watches.test.assignment.error
<br/> --CustomGlobalExceptionHandler.java

<br/>src/test/java
<br/>-com.eshop.selling.watches.test.assignment
<br/> --TestAssignmentApplicationTests.java
</pre>  
  
  

#### 3. Correctly validate the input and return the error HTTP status code
The bean with javax.validation.constraints.* annotations to @Entity Watch class has been added to validate user inputs for properties title and price.

```
// Using Java annotation
	@NotEmpty(message = "*Please provide a title")
	private String title;
	// Using Java annotation, not null and min
	@NotNull(message = "Please provide a price")
    @DecimalMin("1.00")
	private BigDecimal price;
 ```
 @Controller class added @Valid to @RequestBody to enable validation.
 ```
 @ResponseBody
	public ResponseEntity<String> saveWatchJson(@Valid @RequestBody Watch watch)
```
Next, Created @ControllerAdvice CustomGlobalExceptionHandler.java to catch the MethodArgumentNotValidException and override the response to  make it more friendly.



#### 4. Save the received data to any DB (just save the images to the DB) and return 201 CREATED
Saving to the database is done via WatchDao Service which extends CrudRepository, CrudRepository provides sophisticated CRUD functionality for the entity class that is being managed.
<br/>Saving watch object to the database has been tested there is Junit class TestAssignmentApplicationTests.java.
<br/>Returning status codes is done with ResponseEntity, we can use ResponseEntity to fully configure the HTTP response.

#### 5. Prepare the application to change the format of the input data simply, communication with the e-shop can switch to XML or another format (use request header)
Using consumes=MediType.All_VALUE we can change to all input formats with request header.
 ```
@PostMapping(value = "/saveWatch", consumes = MediaType.ALL_VALUE, produces = MediaType.ALL_VALUE)
 ```
 Change of input has been tested with postman, it works same for JSON or XML format.
