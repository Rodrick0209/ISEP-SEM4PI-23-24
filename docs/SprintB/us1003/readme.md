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
- The customer manager must be able to list his job openings by date and choose if he wants to list all of his job
  openings or only the active ones.
- The job opening must be identified by a job reference.

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

#### Test #1: Ensure job openings are beings listed correctly

1. Log in as customer manager
2. Choose the Option Job Opening > List Job Openings
3. Choose the desired filters (By Date, Active/All)
4. Confirm the job openings are being listed correctly


## 5. Implementation

The process of listing job openings involves several components working together. Here's a step-by-step
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