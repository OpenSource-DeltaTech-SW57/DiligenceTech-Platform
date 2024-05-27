## 0.
###### Commit Warning

PLEASE READ THIS BEFORE MAKING A COMMIT:

Never commit the following files, you will ruin the project

![uncommitable-items.PNG](assets/uncommitable-items.PNG)

1. _maven-wrapper.jar_
2. _maven-wrapper.properties_
3. _mvnw_
4. _mvnw.cmd_

## 1.
###### Configuration of Project

1. Using `IntelliJ IDEA Ultimate`
2. Create `New Project`
3. Select `Spring Boot` and follow these steps
    1. Write `name` of project, always ending in '`-platform`'
    2. Select `location` where folder with name will be created
    3. Tick `Create Git repository`
    4. Choose `language` as `Java`
    5. Choose `type` as `Maven`
    6. Write `group` as `com.[startup-name]`
    7. Make sure `artifact` is the same as `name`
    8. In `package name`, make sure `[else]platform` is separated as `[else].platform`
    9. Choose `JDK` as `22` or `anything-22`, if first project, you must configure and install it in `Download JDK`. I use `openjdk-22`
    10. Choose `Java` as `22`
    11. Make sure `packaging` stays as `Jar`
    12. Click `Next`
4. Select `Spring Boot:` `3.2.5` and download the following dependencies
    1. `Developer Tools /`Spring Boot DevTools
    2. `Developer Tools /`Lombok
    3. `Web /`Spring Web
    4. `SQL /`Spring Data JPA
    5. `SQL /`MySQL Driver
    6. `I/O /`Validation
5. Now `Create`
6. IMPORTANT (else it won't work): If you're using `Windows`, make sure to click `Load Maven Project` once the project is created in the `notification` on the `bottom-right`, else it won't work.

_P.D.: Even when `cloning from GitHub` you must follow `Step 6`, it's basically `this project's version` of `npm install`_

## 2.
###### Configuration of Main

Change in `src/main/java/com.startup.project.platform/ProjectPlatformApplication.java`, the main function, the following:

1. New decorator to Focused Function: `@EnableJpaAuditing`

## 3.
###### Base configuration

##### Fixing project with course's nomenclatures

1. Change `HELP.md` to `README.md`

##### Snake Case Strategy

_For this to make sense it's implied you understand how Bounded Contexts are implemented in here_

For starters:

1. In pom.xml add the `Pluralizer` dependency anywhere inside `<dependencies>` (normally after Lombok)

        <!-- https://mvnrepository.com/artifact/io.github.encryptorcode/pluralize -->
        <dependency>
            <groupId>io.github.encryptorcode</groupId>
            <artifactId>pluralize</artifactId>
            <version>1.0.0</version>
        </dependency>
2. Click `Reload Maven Dependencies`, there should be a button once the dependency is added, else it will appear as an error

Now you can continue

Create the package `shared` in `src/main/java/com/startup/project/platform` and create the following structure of packages:

1. infrastructure
    1. infrastructure/persistence
        1. infrastructure/persistence/jpa
            1. infrastructure/persistence/jpa/configuration
                1. infrastructure/persistence/jpa/configuration/strategy

In the package `strategy` create a `Java Class :: Class` called `SnakeCaseWithPluralizedTablePhysicalNamingStrategy`

1. Include in the first line implements
2. It's recommended for you to ask the IDE to implement the functions to override, then you should replace all that content with the one in step 3 (this is to load the dependencies)
3. Write inside the following

        @Override
        public Identifier toPhysicalCatalogName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
            return this.toSnakeCase(identifier);
        }

        @Override
        public Identifier toPhysicalSchemaName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
            return this.toSnakeCase(identifier);
        }

        @Override
        public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
        return this.toSnakeCase(this.toPlural(identifier));
        }

        @Override
        public Identifier toPhysicalSequenceName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
            return this.toSnakeCase(identifier);
        }

        @Override
        public Identifier toPhysicalColumnName(Identifier identifier, JdbcEnvironment jdbcEnvironment) {
            return this.toSnakeCase(identifier);
        }

        private Identifier toSnakeCase(final Identifier identifier) {
            if (identifier == null) {
                return null;
            }
            final String regex = "([a-z])([A-Z])";
            final String replacement = "$1_$2";
            final String newName = identifier.getText()
                .replaceAll(regex, replacement)
                .toLowerCase();
           return Identifier.toIdentifier(newName);
        }

        private Identifier toPlural(final Identifier identifier) {
            final String newName = pluralize(identifier.getText());
            return Identifier.toIdentifier(newName);
        }
4. Hover over the `pluralize` function and make it import the function coming from the `dependency`

##### application.properties

In `src/main/resources/application.properties` write the following

    # Spring Application Name
    spring.application.name=diligencetech-platform

    # Spring DataSource Configuration
    spring.datasource.url=jdbc:mysql://localhost:3306/diligencetech-os?useSSL=false&serverTimezone=UTC
    spring.datasource.username=root
    spring.datasource.password=password
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

    # Spring Data JPA Configuration
    spring.jpa.show-sql=true

    # Spring Data JPA Hibernate Configuration
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.open-in-view=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
    spring.jpa.hibernate.naming.physical-strategy=com.deltatech.diligencetech.platform.shared.infrastructure.persistence.jpa.configuration.strategy.SnakeCasePhysicalNamingStrategy

_Make sure to focus on the first line of `Spring DataSource Configuration`, as that's where the name of your database should be written, and on the last line of `Spring Data JPA Hibernate Configuration` as that's where your strategy should be added_

## 4.
###### Bounded Contexts

Inside `src/main/java/com.startup.project.platform`, create `1 Package as Bounded Context`

For `catch-up-platform`:
1. `news`
2. `shared`

For `diligencetech-platform`:
1. `due-diligence`
2. `project-creation`
3. `qa`
4. `shared`

## 5.
###### Patterns in Bounded Context

_Before beginning, make sure to click in the `Project's toolbar` the `three-dots` => `Tree Appearance` => Untick `Compact Middle Packages`. The way the view settles wouldn't have let you do this step otherwise_

Inside each `Bounded Context`, there must be the following `packages`:

1. `application`
    1. `application/internal`
        1. `application/internal/commandservices`
        2. `application/internal/queryservices`
2. `domain`
    1. `domain/model`
        1. `domain/model/aggregates`
        2. `domain/model/commands`
        3. `domain/model/queries`
    2. `domain/services`
3. `infrastructure`
    1. `infrastructure/persistence`
        1. `infrastructure/persistence/jpa`
            1. `infrastructure/persistence/jpa/configuration`
                1. `infrastructure/persistence/jpa/configuration/strategy`
4. `interfaces`
    1. `interfaces/rest`
        1. `interfaces/rest/resources`
        2. `interfaces/rest/transform`

_P.D.: Btw, you can't write 'interface' as it's a restricted java term_

_You may now tick back `Compact Middle Packages` for easier usage of the IDE_

## 6.
###### Patterns Location in Bounded Context

_First of, realize that each `pattern` is a `Java Class`. Now lets continue_

Here's where each pattern known in Domain-Driven Design will be placed

1. `application`
    1. `application/internal`
        1. `application/internal/commandservices` - **Implementations of Services**
        2. `application/internal/queryservices` - **Implementations of Queries**
2. `domain`
    1. `domain/model`
        1. `domain/model/aggregates` - **Aggregates**
        2. `domain/model/commands` - **Commands**
        3. `domain/model/queries`  - **Queries**
    2. `domain/services` - **Services**
3. `infrastructure`
    1. `infrastructure/persistence`
        1. `infrastructure/persistence/jpa` - **Repositories**
            1. `infrastructure/persistence/jpa/configuration`
                1. `infrastructure/persistence/jpa/configuration/strategy` - **Strategies**
4. `interfaces`
    1. `interfaces/rest` - **Controllers AKA Outbound Communicators**
        1. `interfaces/rest/resources` - **Resources**
        2. `interfaces/rest/transform` - **Assemblers**

## 7.
###### Patterns Theory

1. `Aggregate / Entity / Value Object`: Class diagram's version of data
2. `Command`: Parameters handler of the application's main functions, including the constructors of aggregates
3. `Query`: Permitted query to obtain database's version of data
4. `Service`: Grouping with handling of commands and queries of the same aggregate
5. `Repository AKA Outbound Service`: List of aggregates / entities existing in the application
6. `Implementation of Command Service`: Required declaration of handlers in service
7. `Implementation of Query Service`: Required declaration of handlers in service
8. `Resource`: Endpoint's version of data

## 8.
###### Patterns Requirements

##### Aggregate

Inside `domain/model/aggregates`

1. Create a `Java Class :: Class`
2. Decorate with `@Entity`
3. Decorate with `@EntityListeners(AuditingEntityListener.class)`
4. Aggregate nature:
    1. Requires an `id` attribute (datatype `Long`), must be decorated with `@Id`
    2. The `id` attribute, as it's generated automatically by SQL's rules, must also be decorated with `@GeneratedValue(strategy = GenerationType.IDENTITY)`
    3. Every attribute with a wanted getter must be decorated with `@Getter`
    4. Every attribute with a wanted setter must be decorated with `@Setter`
    5. Every attribute aside of `@Id` must be decorated with `@Column(nullable = false)`
    6. Every value object attribute must be decorated with `@Embedded`
    7. Every collection attribute (datatype of `List`) must be decorated with `@ElementCollection`, or `@OneToMany` or `@ManyToMany`
    8. If a date created attribute wants to be added, it must be decorated with `@CreatedDate` and use `java.util.Date` (not java.sql.Date)
    9. If a last updated date attribute wants to be added, it must be decorated with `@LastModifiedDate` and use `java.util.Date` (not java.sql.Date)
    10. If an attribute has a very different name in the database use `@AttributeOverrides({ @AttributeOverride(name = "attribute_name", column = @Column(name ="database_name")) })`
    11. A value object is specially the attribute that will have many `@AttributeOverride` inside `@AttributeOverrides`
    12. Needs a constructor that has its `Command` as `parameter`, then each `attribute` must be initialized with the `Command's version`
5. Pattern dependencies:
    1. Must have `Command` created to complete

##### Value Objects

Inside `domain/model/valueobjects`

1. Create a `Java Class :: Record`
2. Decorate with `@Embeddable`
3. Value object nature:
    1. All attributes are declared as parameters
    2. Functions can be declared as in a normal aggregate or entity
    3. A general constructor must be created that error handles if attributes are null or blank (for basic attributes)
    4. Particular constructors must be created that specifies which attributes can be set and which can be null at aggregate's creation (for basic attributes)
    5. A particular constructor must be created that returns nulls for the quantity of attributes


    For 2: this(null, null)
    For 3: this(null, null, null)

##### Commands

Inside `domain/model/commands`

Named as verb + aggregate + `Command`. Like `CreateProjectCommand`

1. Create a `Java Class :: Record`
2. Command nature:
    1. All attributes from the aggregate must be added as parameters
    2. If error handling wanted, create a general constructor with the logic

##### Queries

Inside `domain/model/queries`

Named as `Get` + Explanation of Query + `Query`. Like `GetAllProjectsQuery` or `GetProjectByIdQuery`

1. Create a `Java Class :: Record`
2. Query nature:
    1. All attributes used in SQL boolean expressions must be included as parameters

##### Services

Inside `domain/services`

Named as aggregate + `Command`/`Query` + `Service`. Like `ProjectCommandService` or `ProjectQueryService`

1. Create a `Java Class :: Interface`
2. Service nature:
    1. For each `command`/`query` encompassed create a `function` called `handle` with `Optional<AggregateName>` as `output`, and the focused `command`/`query` as `parameter`. Like `Optional<Project> handle(CreateProjectCommand command);` or `Optional<Project> handle(GetProjectByIdQuery query);`
        1. For query only, if the `query` is expected to return a `list` of aggregates, use `List<AggregateName>` as output instead. Like `List<Project> handle(GetAllProjectsQuery query);`

##### Repositories

Inside `infrastructure/persistence/jpa/repositories`

Named as aggregate + Repository. Like `ProjectRepository`

1. Create a `Java Class :: Interface`
2. Include in first line `extends JpaRepository<AggregateName, IdDataType>`. Like extends `JpaRepository<Project, Long>`
3. Decorate with `@Repository`
4. Repository nature:
    1. For each way to `get` a `group or single` one of the `aggregates` working in the application, there must be a `function` that uses `Optional<AggregateName>` or `List<AggregateName>` as output, `find` + function's purpose as its name, and values needed to realize the search as parameters

##### Implementations of Command Services

Inside `application/internal/commandservices`

1. Create a `Java Class :: Class`
2. Decorate with `@Service`

##### Implementations of Query Services

Inside `application/internal/queryservices`

1. Create a `Java Class :: Class`
2. Decorate with `@Service`
