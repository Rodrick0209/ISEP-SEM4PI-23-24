# US 1000a

## 1. Context

This task, identified as "US 1006", is being assigned for the first time. The context for this task is to display all
candidate's information.

## 2. Requirements

**US 1006** As Customer Manager, I want to display all the personal data of a candidate.

**Dependencies/References:**

- Just the candidate details

## 3. Analysis

## Client Meeting

- À partida diria que seria o nome, tal como foi recebido na application que fez (página 6, “name of the candidate”)
- No contexto actual vamos assumir que o Customer Manager pode aceder (consultar) os dados pessoais de qualquer
  candidato.
- O product owner espera que o sistema aplique as melhores práticas de UI/UX mas, não sendo especialista nessa área
  técnica, não arrisca sugerir soluções.
- Será toda a informação pessoal de um candidato que o sistema tenha registado.
- 

## Business Rules

- This US is directly related to the candidates of the backoffice.
- To see the candidates information the user must be a customer manager.
- The user must have an email, name, and password.
- The customer manager must be able to see all the personal data of a candidate.

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

1. Log in as customer manager
2. Choose the Option Candidate > Display Candidate Information
3. Choose the desired filters (By Date, Active/All)
4. Confirm the job openings are being listed correctly

## 5. Implementation

The process of registering a new user in this system involves several components working together. Here's a step-by-step
explanation

- **User Interface (ListJobOpeningUI.java)**: The process starts in the ListJobOpeningUI class, which is
  responsible for interacting
  with the user. It prompts the user to enter the necessary information.
  This class uses the ListJobOpeningController to handle the business logic.
- **Controller (ListJobOpeningController.java):** The ListJobOpeningController class is the bridge between the
  UI and the business
  logic.
- **Repository (JobOpeningRepository):** The JobOpeningRepository is an interface that defines the methods for
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
2. Navigate to the job openings section and select the option to list job openings.
3. Select the desired listing filters.
4. If there are job openings that match the selected filters, they will be displayed on the screen.
5. If there are no job openings that match the selected filters, a message will be displayed indicating that there are
   no
   job openings to display.

This process demonstrates the system's ability to list job openings based on the selected filters.

## 7. Observations

- Nothing to add.

```