##### Bounded Context's Layers

1. Application
    1. application/internal
        1. application/internal/commandservices - **Command Services Impl**
       2. application/internal/queryservices - **Query Services Impl**
       3. application/internal/outboundservices
            1. application/internal/acl - **External Services**
       4. application/internal/eventhandlers - **Event Handlers**
2. Domain
    1. domain/models
         1. domain/models/aggregates - **Aggregates**
         2. domain/models/entities - **Entities**
         3. domain/models/valueobjects - **Value Objects**
         4. domain/models/commands - **Commands**
         5. domain/models/Queries - **Queries**
         6. domain/models/events - **Events**
    2. domain/services - **Command and Query Services**
    3. domain/exceptions - **Exceptions**
3. Infrastructure
    1. infrastructure/persistence
        1. infrastructure/persistence/jpa
            1. infrastructure/persistence/jpa/repositories - **Repositories**
4. interfaces
    1. interfaces/acl - **Facades**
   2. rest


##### Shared Bounded Context's Patterns

1. infrastructure
    1. infrastructure/persistence
        1. infrastructure/persistence/jpa
            1. infrastructure/persistence/jpa/configuration
                1. infrastructure/persistence/jpa/configuration/strategy - **Strategies**
    2. infrastructure/documentation
        1. infrastructure/documentation/openapi
            1. infrastructure/documentation/openapi/configuration - **OpenAPI Configuration**

##### Pattern Quantities

    // Results
    databaseTables[a + b]
    classes[a + b + c]
    endpoints[f]
    // Application
    commandServices[a]
    queryServices[a]
    // Domain
    aggregates[a]
    entities[b]
    valueobjects[c]
    commands[a]
    queries[d * a]
    events[e]
    services[2 * a]
    // Infrastructure
    repositories[a]
    // Interfaces
    controllers[f]
    resources[f]
    createResources[f]
    assemblers[2 * f]

##### Pattern Requirements

###### Facade

Inside `interfaces/acl` of `Giving Bounded Context`

1. Create `Java Class :: Class`
2. Decorate with `@Service`
3. Has `CommandServices` and `QueryServices` as `attributes`
4. Has `constructor` to inject CommandServices and QueryServices
5. Has `methods` to create or find entities, but gives Ids instead of references (DDD rules)
    1. `Create methods`: Dedicated to create and give Ids if created with CommandServices
   2. `Fetch methods`: Dedicated to find and give Ids if found with QueryServices

### External Services

Inside `application/internal/outboundservices/acl` of `Receiving Bounded Context`

1. Create `Java Class :: Class`
2. Decorate with `@Service`
3. Has `Facades` from `other bounded contexts` as `attributes`
4. Has `constructor` to inject `Facades`
5. Has `methods` to create or find entities, but gives Ids instead of references (DDD rules)
    1. `Create methods`: Dedicated to create and give Ids if created with Facades
   2. `Fetch methods`: Dedicated to find and give Ids if found with Facades

### Command Services Impl

Inside `application/internal/commandservices`

1. Create `Java Class :: Class`
2. Decorate with `@Service`
3. In first line write `implements XXXXCommandService`
4. 
