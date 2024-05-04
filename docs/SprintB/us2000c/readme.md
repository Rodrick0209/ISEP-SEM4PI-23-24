# US 2000c

## 1. Context

This task, identified as "US 2000c", is being assigned for the first time. The context for this task is to manage candidates in the system. As an Operator, the user should be able to list all candidates.
## 2. Requirements

**1000c** As Operator, I want to be able to list all candidates.

**Dependencies/References:**

- N/A

## 3. Analysis
## Business Rules

- This US is directly related to the users of the backoffice.
- The listing of users only shows candidates.
- The listing of users must show the user's name and email.

## 4. Design


### 4.1. Realization


![Disable User](SD/SD.png)

### 4.2. Class Diagram
![Enable User](CD/ListUsersUI.png)


### 4.3. Applied Patterns


In the development of this task, we utilized several design patterns to structure our code and ensure its maintainability and scalability. These patterns include:
- **Repository Pattern:** The Repository pattern was used to create an abstraction layer between the data access layer and the business logic layer of the application. This helps to decouple the application and make it easier to maintain and test.
- **Service Pattern:** The Service pattern was used to encapsulate business logic and rules. This pattern provides a set of methods that any client application can use, and these methods implement the business rules and logic.
- **Controller Pattern:** The Controller pattern was used in the presentation layer of the application. Controllers handle incoming requests, manipulate data using the model, and select views to render to the user

### 4.4. Tests

#### Case #1: List User

1. Log in as operator
2. Choose the Candidate > List candidates options
3. Display all the users (email and name)


#### Case #2: List User (does not exist users)

1. Log in as operator
2. Choose the Candidate > List candidates options
3. Display a message "There are no candidates"




## 5. Implementation

The process of listing candidates in this system involves several components working together. Here's a step-by-step explanation:
- **User Interface (ListCandidatesUI.java):** The user interface is responsible for displaying the list of candidates. It interacts with the ListCandidatesController to retrieve the list of candidates.
- **Controller (ListCandidatesController.java):** The ListCandidatesController class is the bridge between the UI and the business logic. It interacts with the CandidateRepository to retrieve the list of candidates.
- **Repository (CandidateRepository):** The CandidateRepository is an interface that defines the methods for interacting with the database. It extends the DomainRepository interface, which provides methods for basic CRUD operations.

## 6. Integration/Demonstration

### Integration

We seamlessly integrated our functionality by leveraging an existing service that included both a repository and a controller. This approach allowed us to efficiently integrate our solution into the system without duplicating efforts or reinventing existing components.

### Demonstration

To demonstrate the functionality follow the steps below:

1. Log in as operator
2. Choose the Candidate > List candidates options
3. Display all the users (email and name)


This process demonstrates the system's ability to list backoffice users and display their email and name.

## 7. Observations
