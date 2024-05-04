# US 1006

## 1. Context

This task, identified as "US 1005", is being assigned for the first time. The context for this task is to display all job application.

## 2. Requirements

**US 1005** As Operator, I want to list all applications for a job opening.

**Dependencies/References:**

- N/A

## 3. Analysis

## Client Meeting

- Tal como refere a descrição da US, devem ser listadas todas as candidaturas para um job opening. Faz sentido mostrar
  todas as candidaturas, independentemente do seu estado. Assim, para cada cada candidatura deve ser identificado o candidato e o estado da sua candidatura

## Business Rules

- This user story should only be accessible to the Operator users.
- The user must be able to see all the applications for a job opening.
- When listing the applications, the user must be able to see the candidate and the application data.te.

## 4. Design

### 4.1. Realization

### 4.2. Class Diagram

### 4.3. Applied Patterns

In the development of this task, we utilized several design patterns to structure our code and ensure its
maintainability and scalability. These patterns include:

- **Repository Pattern:** The Repository pattern was used to create an abstraction layer between the data access layer
  and the business logic layer of the application. This helps to decouple the application and make it easier to maintain
  and test.
- **Controller Pattern:** The Controller pattern was used in the presentation layer of the application. Controllers
  handle incoming requests, manipulate data using the model, and select views to render to the user

### 4.4. Tests

#### Test #1: Ensure candidates information is being displayed correctly

1. Log in as operator
2. Choose the Applications > List Applications options
3. Choose the job opening
4. Display all the applications (candidate and application data)

## 5. Implementation

The process of displaying candidates information involves several components working together. Here's a step-by-step
explanation

- **User Interface (DisplayCandidateInfoUI.java)**: The process starts in the DisplayCandidateInfoUI class, which is
  responsible for interacting
  with the user. It prompts the user to enter the necessary information.
  This class uses the DisplayCandidateInfoController to handle the business logic.
- **Controller (DisplayCandidateInfoController.java):** The DisplayCandidateInfoController class is the bridge between the
  UI and the business
  logic.
- **Repository (CandidateRepository):** The CandidateRepository is an interface that defines the methods for
  interacting with the
  database. It extends the DomainRepository interface, which provides methods for basic CRUD operations.

## 6. Integration/Demonstration

### Integration

We seamlessly integrated our functionality by leveraging an existing service that included both a repository and a
controller. This approach allowed us to efficiently integrate our solution into the system without duplicating efforts
or reinventing existing components.

### Demonstration

To demonstrate the functionality follow the steps below:

1. Start the application and log in as a customer manager.
2. Navigate to the candidate section and select the option to display candidate information.
3. Select the desired way you want the candidates information to be displayed.
4. If there are candidates , they will be displayed on the screen.
5. If there are no candidates, a message will be displayed indicating that there are
   no
   candidates to display.

This process demonstrates the system's ability to list job openings based on the selected filters.

## 7. Observations

- Nothing to add.
