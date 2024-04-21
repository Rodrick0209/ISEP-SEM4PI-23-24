# US 1000a

## 1. Context

This task, identified as "US 1003", is being assigned for the first time. The context for this task is to list job
openings.

## 2. Requirements

**US 1003** As Customer Manager, I want to list job openings.

**Dependencies/References:**

- None

## 3. Analysis

## Client Meeting

- Suponho que poder filtrar por Customer e data seja útil. Também poder filtrar apenas as activas ou todas parece-me
  útil.
- O Customer é tipicamente uma empresa e tem um nome. Também já foi referida a existência de um customer code. Quanto ao
  filtro por data se estiverem no papel do customer manager que tem de consultar job openings faz sentido ser para um
  dia? Ou seja ele teria de sabe em que dia é que registou o job opening que está a pesquisar…

## Business Rules

- This US is directly related to the users of the backoffice.
- To list job openings the user must be a customer manager.
- The user must have an email, name, and password.
- The customer manager must be able to list his job openings by date and choose if he wants to list all of his job openings or only the active ones.
- The job opening must be identified by a job reference.

## 4. Design

### 4.1. Realization

![SD1002.svg](SD%2FSD1002.svg)

### 4.2. Class Diagram

### 4.3. Applied Patterns

In the development of this task, we utilized several design patterns to structure our code and ensure its
maintainability and scalability. These patterns include:

- **Factory Pattern:** This pattern was used to construct complex objects step by step. It separates the construction of
  an object from its representation, allowing the same construction process to create different representations.
- **Repository Pattern:** The Repository pattern was used to create an abstraction layer between the data access layer
  and the business logic layer of the application. This helps to decouple the application and make it easier to maintain
  and test.
- **Service Pattern:** The Service pattern was used to encapsulate business logic and rules. This pattern provides a set
  of methods that any client application can use, and these methods implement the business rules and logic.
- **Controller Pattern:** The Controller pattern was used in the presentation layer of the application. Controllers
  handle incoming requests, manipulate data using the model, and select views to render to the user

### 4.4. Tests

#### Test #1: Create job openings successfully

1. Log in as customer manager
2. Choose the Option Job Opening > Register Job Opening
3. Fill the necessary information
7. The system displays a success message "Job Opening created successfully."
8. Confirm the job opening was created through List of job openings (Job Opening > List job openings)

#### Test #2: Ensure job reference is unique

1. Log in as customer manager
2. Choose the Option Job Opening > Register Job Opening3. Fill the necessary information
7. The system displays a success message "Job Opening created successfully."
8. Repeat the process in order to create another job opening
9. Confirm the job openings were created with different job references through List of job openings (Job Opening > List
   job openings)

## 5. Implementation

The process of registering a new user in this system involves several components working together. Here's a step-by-step
explanation

- **User Interface (RegisterJobOpeningUI.java)**: The process starts in the RegisterJobOpeningUI class, which is
  responsible for interacting
  with the user. It prompts the user to enter the necessary information.
  This class uses the RegisterJobOpeningController to handle the business logic.
- **Controller (RegisterJobOpeningController.java):** The RegisterJobOpeningController class is the bridge between the
  UI and the business
  logic. It uses the JobOpeningFactory to register the new job opening. It also uses the JobReferenceService to
  generate a job reference for the new job opening.
- **Repository (JobOpeningRepository):** The JobOpeningRepository is an interface that defines the methods for
  interacting with the
  database. It extends the DomainRepository interface, which provides methods for basic CRUD operations.

## 6. Integration/Demonstration

### Integration

We seamlessly integrated our functionality by leveraging an existing service that included both a repository and a
controller. This approach allowed us to efficiently integrate our solution into the system without duplicating efforts
or reinventing existing components.

### Demonstration

To demonstrate the functionality and the handling of invalid inputs, follow the steps below:

1. Start the application and log in as a customer manager.
2. Navigate to the job openings section and select the option to register job opening.
3. In the form that appears, fill the required fields with valid information.
4. Submit the form. The system displays a success message "Job opening was not registered."
5. To confirm that the job opening was not created, navigate to the List Job Openings section under Job Opening. The new
   job opening should not appear in the list.

This process demonstrates the system's ability to validate job openings input and successfully register a job opening
with valid details.

## 7. Observations

- Nothing to add.

```