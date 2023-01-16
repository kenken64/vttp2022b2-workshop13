## Workshop 13 (v1.1)

- Run the spring boot app

Linux/Macos

```
mvn spring-boot:run -Dspring-boot.run.arguments=--dataDir=/opt/tmp/data
```

Windows 10/11

```
mvn spring-boot:run -Dspring-boot.run.arguments=--dataDir=C:/data
```

- Incorporate test starter dependencies to the pom.xml

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-test</artifactId>
    <version>2.7.1</version>
    <scope>test</scope>
</dependency>

```

- In order to execute test cases

```
mvn test
```

```
mvn package
```

```
java -jar workshop13-0.0.1-SNAPSHOT.jar --dataDir=/opt/tmp/data
```
