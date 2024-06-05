## Identity and Access Management (IAM)

- Register User (Sign-Up)
- Authenticate User (Sign-In)
- Authorize Requests

-----------

- Password Encryption / Validation (Hashing)
- Token Generation / Validation (Tokens, JWT)
- Spring Boot Request Pipeline (Filters)
- Open API Documentation Configuration (No Swagger anymore, Sec)



--------

Remember:
1. Database Modelling
2. Configuration
3. Modelling
4. Endpoint

---------

Registrar nuevas dependencias en pom.xml (io.jsonwebtoken)

1. jjwt-api (0.12.3)
2. jjwt-jackson (0.12.3)

        <!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api -->
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-api</artifactId>
			<version>0.12.3</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl -->
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-impl</artifactId>
			<version>0.12.3</version>
			<scope>runtime</scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson -->
		<dependency>
			<groupId>io.jsonwebtoken</groupId>
			<artifactId>jjwt-jackson</artifactId>
			<version>0.12.3</version>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>3.12.0</version>
		</dependency>