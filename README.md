# Spring boot REST API 

A simple REST API built with the java framework [spring boot](https://spring.io/projects/spring-boot). The API implements a CRUD for managing video games. 

## Technical stack
Regarding the stack you will find: 

- [MySQL](https://www.mysql.com/) our database 
- [Docker](https://www.docker.com/) for our containerize platform.
- [Junit](https://junit.org/junit5/) for unit tests.
- [Mockito](https://site.mockito.org/) for mocks in tests. 
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) for the interaction with the database.
- [Maven](https://maven.apache.org/) as build tool. 

## Requirement 
- Docker installed

## Usage 
- Clone the repository 

```
    git clone git@github.com:niemet0502/spring-boot-rest-api.git
```

- Change the directory 

```
    cd spring-boot-rest-api
```

- Run the stack by using [Docker compose](https://docs.docker.com/compose/)

```
    docker compose --build
```
Compose will build the image then run the services.

You should be able to access the server at http://localhost:7003
## Testing 

### Unit tests 
There are written using [JUnit]() and [Mockito]() for mocking. 

You can run test with the command below: 

```
    mvn test
```
<table>
<tr>
    <th>Unit Tests</th>
</tr>
    <tr>
        <td><img src="screenshots/unit-tests.png" alt="unit-tests-restults"></td>
    </tr>
</table>

## Documentation 

## Demo 

## Built by

- Marius Vincent NIEMET [Twitter](https://twitter.com/mariusniemet05) [LinkedIn](https://www.linkedin.com/in/marius-vincent-niemet-928b48182/) 

