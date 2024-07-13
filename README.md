# NCAPAS Rest API to Manager Persons

NCAPAS API is a Spring Boot REST API project for managing people with Object-Relational Mapping (ORM). This project includes various endpoints for creating, retrieving, updating, and deleting person records, along with managing addresses associated with those persons.

## Table of Contents

- [NCAPAS API](#ncapas-api)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
  - [Requirements](#requirements)
  - [Installation](#installation)
  - [Configuration](#configuration)
  - [Usage](#usage)
    - [Endpoints](#endpoints)
  - [Development](#development)
  - [License](#license)
  - [Contact](#contact)

## Features

- Create, read, update, and delete (CRUD) operations for Person entities.
- Search persons by various criteria (email, city, identification).
- Retrieve addresses associated with a person.
- Swagger UI integration for API documentation.

## Requirements

- Java 17 or higher
- Maven 3.6.0 or higher
- PostgreSQL 12 or higher (configured as the default database)
- Optional: MySQL database support

## Installation

1. Clone the repository:
   ```sh
   git clone https://github.com/Anyel-ec/SpringBoot-ORM-Rest-API-Persons
   cd SpringBoot-ORM-Rest-API-Persons
   ```

2. Build the project using Maven:
   ```sh
   mvn clean install
   ```

## Configuration

1. Update the database configuration in the `application.properties` file:
   ```properties
   ## PostgreSQL Configuration
   spring.datasource.url=jdbc:postgresql://localhost:5432/spring_person
   spring.datasource.username=postgres
   spring.datasource.password=postgres
   spring.datasource.driver-class-name=org.postgresql.Driver

   ## Optional: MySQL Configuration
   #spring.datasource.url=jdbc:mysql://localhost:3306/spring_person
   #spring.datasource.username=root
   #spring.datasource.password=anyel
   #spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

   ## Hibernate Properties
   spring.jpa.show-sql=true
   spring.jpa.hibernate.ddl-auto=create-drop

   ## Spring Doc Configuration
   springdoc.api-docs.enabled=true
   springdoc.swagger-ui.enabled=true
   springdoc.swagger-ui.path=/swagger-ui.html
   ```

2. Run the application:
   ```sh
   mvn spring-boot:run
   ```

## Usage

Once the application is running, you can access the Swagger UI to interact with the API documentation and test the endpoints at: 
```
http://localhost:8080/swagger-ui.html
```

### Endpoints

- `POST /persons/v1/save`: Save a new person.
- `GET /persons/v1/findAll`: Retrieve all persons.
- `GET /persons/v1/findById/{id}`: Retrieve a person by ID.
- `PUT /persons/v1/updateById/{id}`: Update a person by ID.
- `DELETE /persons/v1/deleteById/{id}`: Delete a person by ID.
- `GET /persons/v1/address/house/{id}`: Retrieve house addresses for a person by ID.
- `GET /persons/v1/findAllByEmailCity`: Retrieve persons by email and city.
- `GET /persons/v1/findByIdentification`: Retrieve persons by identification.

## Development

### Project Structure

- `top.anyel.orm.config`: Contains the configuration class for OpenAPI documentation.
- `top.anyel.orm.controllers`: Contains REST controller classes for handling HTTP requests.
- `top.anyel.orm.models`: Contains the model classes representing the entities.
- `top.anyel.orm.repositories`: Contains the repository interfaces for database operations.
- `top.anyel.orm.services`: Contains service classes for business logic.

### Dependencies

The `pom.xml` file includes dependencies for Spring Boot, Spring Data JPA, validation, Swagger, PostgreSQL, and optional MySQL support.

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-devtools</artifactId>
        <scope>runtime</scope>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.springdoc</groupId>
        <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
        <version>2.5.0</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-validation</artifactId>
        <version>3.3.0</version>
    </dependency>
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
</dependencies>
```

## License

This project is licensed under the Apache License 2.0. See the [LICENSE](LICENSE) file for details.

## Contact

Developed by Anyel EC - [cyberdevmatrix@gmail.com](mailto:cyberdevmatrix@gmail.com)
