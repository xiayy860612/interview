# New User Task

## Requirements

- Java 8
- JUnit 4
- Maven 3.5.2

## Project Structure

root        // project root directory
  |- doc    // project documents here
  |- src    // project source code
      |- nu-account     // executable jar
      |- nu-core        // core library for other project

## How to build

1. open a shell
2. cd directory of source code
3. run command `mvn clean package`
4. executable jar file **nu-account-1.0-SNAPSHOT.jar** under **nu-account/target**
5. run application by command `java -jar nu-account-1.0-SNAPSHOT.jar`
6. access **http://localhost:8080/swagger-ui.html** to try all apis
7. access **http://localhost:8080/h2-console** to check database
