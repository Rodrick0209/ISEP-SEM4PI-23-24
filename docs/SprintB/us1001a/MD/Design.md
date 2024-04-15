# Design

- Use the standard base structure of the layered application


### Domain Classes

- SystemUser,Jobs4uUser,Client

### Controller

- RegisterClientController - For registering a client
- AddUserOnClientRegistedController - For adding a user to a client
- AddClientUserOnClientRegistedController - For adding a clientUser 

### Events and Watchdogs

- ClientRegisteredEvent - For handling the event of a client being registered
- NewUserRegisteredFromClientRegistedEvent - For handling the event of a new user being registered from a client being registered
- ClientRegistedWatchdog - For watching the event of a client being registered
- NewUserRegisteredFromClientRegistedWatchDog - For watching the event of a new user being registered from a client being registered

### Service

- AuthenticationService

### Repository

- Jobs4uUserRepository,ClientRepository,SystemUserRepository