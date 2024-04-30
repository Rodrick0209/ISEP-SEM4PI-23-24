# US 1011

## 1. Context

This task, identified as "US 1011", is being assigned for the first time. The context for this task is to select a Interview Model Specification for a Job Opening.

## 2. Requirements

**US 1011** As Customer Manager, I want to select the interview model to use for the interviews of a job opening (for their evaluation/grading).

**Acceptance Criteria:**
- 1009.1. The system should select successfully a Interview Model Specification for a Job Opening.
- 1009.2. The system should select a valid Job Opening.
- 1009.3. The system should select a valid Interview Model Specification.

**Dependencies/References:**

- NFR09(LPROG) - Requirement Specifications and Interview Models The support
  for this functionality must follow specific technical requirements, specified in LPROG.
  The ANTLR tool should be used (https://www.antlr.org/).

## 3. Analysis

### Client meeting

-  Na US1011, o Customer manager seleciona o interview model a usar nas entrevistas para um job opening. Ou seja, existirá apenas um interview model a usar nas entrevistas desse job opening.
-  Sobre as entrevistas, a 1011 indica que o customer manager seleciona o “interview model” a usar para as entrevistas de um “job opening”. Assim, estamos a admitir que será sempre o mesmo interview model para todas as entrevistas, ou seja, todas as entrevistas terão as mesmas perguntas. Ou seja, é adequado admitir que só vai haver uma entrevista para um “job opening”.

### Business Rules

- This US is directly related to the users of the backoffice.
- To select a Interview Model Specification for a Job Opening the user must be a customer manager.
- The user must have an email, name, and password.
- The interview model specification must be identified by a name.
- The job opening must be identified by a job reference.

## 4. Design

### 4.1. Realization

![SD](SD/SD.svg)

### 4.2. Class Diagram

![CD](CD/CD.svg)

### 4.3. Applied Patterns

In the development of this task, we utilized several design patterns to structure our code and ensure its
maintainability and scalability. These patterns include:


- **Repository Pattern:** The Repository pattern was used to create an abstraction layer between the data access layer
  and the business logic layer of the application. This helps to decouple the application and make it easier to maintain
  and test.
- **Controller Pattern:** The Controller pattern was used in the presentation layer of the application. Controllers
  handle incoming requests, manipulate data using the model, and select views to render to the user

### 4.4. Tests

**Test 1:** *Verifies that is possible to select a Interview Model Specification to a Job Opening*

**Refers to Acceptance Criteria:** 1011.1

```
@Test(expected = success)
public void ensurePossibleToSelectAInterviewModelSpecificationForAJobOpening() {
        JobOpening jobOpening = new JobOpening(...);
        InterviewModelSpecification interviewModelSpecification = new InterviewModelSpecification(...);
        jobOpening.selectInterviewModelSpecification(interviewModelSpecification);
}
```

**Test 1:** *Verifies that it is not possible to select a Interview Model Specification to a invalid Job Opening*

**Refers to Acceptance Criteria:** 1011.2


```
@Test(expected = NullPointerException.class)
public void ensureNotPossibleToSelectAInterviewModelSpecificationForAInvalidJobOpening() {
	JobOpening jobOpening = null;
	InterviewModelSpecification interviewModelSpecification = new InterviewModelSpecification(...);
        jobOpening.selectInterviewModelSpecification(interviewModelSpecification);
}
````

**Test 2:** *Verifies that is not possible to select a invalid Interview Model Specification to a Job Opening*

**Refers to Acceptance Criteria:** 1011.3

```
@Test(expected = IllegalArgumentException.class)
public void ensureNotPossibleToSelectAInvalidInterviewModelSpecificationForAJobOpening()
    JobOpening jobOpening = new JobOpening(...);
    InterviewModelSpecification interviewModelSpecification = null;
    jobOpening.selectInterviewModelSpecification(interviewModelSpecification);
}
```

## 5. Implementation

The process of selecting a Job Requirement Specification for a Job Opening in this system involves several components working together. Here's a step-by-step
explanation

- **User Interface (SelectInterviewModelSpecificationForJobOpeningUI.java)**: The process starts in the SelectInterviewModelSpecificationForJobOpeningUI class, which is
  responsible for interacting
  with the user. It prompts the user to enter the necessary information.
  This class uses the SelectInterviewModelSpecificationForJobOpeningController to handle the business logic.
- **Controller (SelectInterviewModelSpecificationForJobOpeningController.java):** The SelectInterviewModelSpecificationForJobOpeningController class is the bridge between the
  UI and the business
  logic.
- **Repository (JobOpeningRepository):** The JobOpeningRepository is an interface that defines the methods for
  interacting with the
  database. It extends the DomainRepository interface, which provides methods for basic CRUD operations.
- **Repository (InterviewModelSpecificationRepository):** The InterviewModelSpecificationRepository is an interface that defines the methods for
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
2. Navigate to the job openings section and select the option to select a Interview Model Specification for a Job Opening.
3. Select the Job Opening.
4. Select the Interview Model Specification.

## 7. Observations

- Nothing to add.