
# Layered Architecture Demo

## Build and Run

- ### Build Project
```
mvn clean install
```

- ### Build Project and skip tests
```
mvn clean install -Dmaven.test.skip
```

- ### Start Application
```
mvn spring-boot:run
```

- ### Run Unit Test
```
mvn test
```

## REST API
Exposed port 8085

### Sample Message Format
```json
{
    "id": 0,
    "data": [
      "object0",
      "object1",
      "object2"
    ],
    "message": "message0"
}
```

