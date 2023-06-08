# SSAB Server

## REST API Endpoints
Here's a deep dive into the all the REST endpoints, including the models, their properties, and the request/response for each endpoint:

### User Registration:

#### Request:
* Endpoint: POST /api/users/register 
* Request Body: { name, email, password }
#### Response:
* Status 201: User successfully registered 
* Status 400: Invalid input or duplicate email 
* Status 500: Internal server error

### User Login:
#### Request:
* Endpoint: POST /api/users/login
* Request Body: { email, password }
#### Response:
* Status 200: Login successful, returns access token
* Status 400: Invalid credentials
* Status 500: Internal server error

### Browse Services:
#### Request:
* Endpoint: GET /api/services
#### Response:
* Status 200: Returns an array of services [{ id, name, description, price }]
* Status 500: Internal server error

### Selecting a Service:
#### Request:
* Endpoint: GET /api/services/{serviceId}
#### Response:
* Status 200: Returns the details of the selected service { id, name, description, price }
* Status 404: Service not found
* Status 500: Internal server error

### Check Availability:
#### Request:
* Endpoint: GET /api/services/{serviceId}/availability?date={selectedDate}
#### Response:
* Status 200: Returns available time slots for the selected service and date [{ id, startTime, endTime }]
* Status 400: Invalid input or date format
* Status 500: Internal server error

### Booking an Appointment:
#### Request:
* Endpoint: POST /api/appointments
* Request Body: { userId, serviceId, date, timeSlotId, notes }
#### Response:
* Status 201: Appointment successfully booked, returns the appointment details { id, userId, serviceId, date, timeSlotId, notes }
* Status 400: Invalid input or appointment clash
* Status 500: Internal server error

### View Upcoming Appointments:
#### Request:
* Endpoint: GET /api/appointments?userId={userId}
#### Response:
* Status 200: Returns an array of upcoming appointments for the specified user [{ id, userId, serviceId, date, timeSlotId, notes }]
* Status 500: Internal server error

### Reschedule or Cancel Appointment:
#### Request:
* Endpoint: PUT /api/appointments/{appointmentId}
* Request Body: { date, timeSlotId }
#### Response:
* Status 200: Appointment successfully rescheduled or canceled, returns the updated appointment details { id, userId, serviceId, date, timeSlotId, notes }
* Status 400: Invalid input or appointment clash
* Status 404: Appointment not found
* Status 500: Internal server error

### Provide Feedback and Ratings:
#### Request:
* Endpoint: POST /api/appointments/{appointmentId}/feedback
* Request Body: { rating, comment }
#### Response:
* Status 201: Feedback successfully submitted
* Status 400: Invalid input
* Status 404: Appointment not found
* Status 500: Internal server error

### Support and Assistance:
#### Request:
* Endpoint: GET /api/support/faq
#### Response:
* Status 200: Returns an array of frequently asked questions [{ id, question, answer }]
* Status 500: Internal server error

### Contact Customer Support:
#### Request:
* Endpoint: POST /api/support/contact 
* Request Body: { name, email, message }
#### Response:
* Status 201: Support request successfully submitted 
* Status 400: Invalid input 
* Status 500: Internal server error

These are example endpoints with their associated request and response details. You can customize them based on your specific needs, including additional properties or validation rules for each model.

### Open API Documentation
springdoc-openapi java library helps to automate the generation of API documentation using spring boot projects. springdoc-openapi works by examining an application at runtime to infer API semantics based on spring configurations, class structure and various annotations.

Automatically generates documentation in JSON/YAML and HTML format APIs. This documentation can be completed by comments using swagger-api annotations.

Add the library to the list of your project dependencies (No additional configuration is needed)
```xml
   <dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webflux-ui</artifactId>
      <version>2.1.0</version>
   </dependency>
```

The Swagger UI page will then be available at 
```css
http://server:port/context-path/swagger-ui.html 
```
and the OpenAPI description will be available at the following url for json format: 
```css
http://server:port/context-path/v3/api-docs
```
* server: The server name or IP 
* port: The server port 
* context-path: The context path of the application

Documentation can be available in yaml format as well, on the following path : /v3/api-docs.yaml
### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.0/maven-plugin/reference/html/#build-image)
* [Spring Reactive Web](https://docs.spring.io/spring-boot/docs/3.1.0/reference/htmlsingle/#web.reactive)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a Reactive RESTful Web Service](https://spring.io/guides/gs/reactive-rest-service/)

