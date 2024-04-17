# Design

- Use the standard base structure of the layered application


### Domain Classes

- Candidate,SystemUser,Jobs4uUser

### Controller

- RegisterCandidateController - To register a candidate

### Events and Watchdogs

- CandidateRegisteredEvent - To handle the candidate registration event

### Service

- AuthenticationService

### Repository

- Jobs4uUserRepository,CandidateRepository,SystemUserRepository