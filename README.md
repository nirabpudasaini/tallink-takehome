## Conference Booking API

### Running the App

Clone the code locally. Make sure you have docker compose installed.

You can run the app by 
```bash
$ ./gradlew bootRun
```
The application will run a docker container with postgres and expose the database port. The database settings can be seen and configured in the compose.yaml file in the project root. 

The application will be available at port 8080. If the port is unavailable it can be configured from the application.properties file in the resources directory.

### Running the Tests
Preconfigured test can be run by the following command
```bash
$ ./gradlew test
```

Endpoints can be viewed and tested via swagger ui which should be available at `/swagger-ui/index.html`

### Tech Stack
- Java 21
- postgreSQL 17
- Spring Boot
- Gradle
- OpenApi 3
- Flyway
- Docker compose