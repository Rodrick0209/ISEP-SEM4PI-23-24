# US 1004

## 1. Context

This task, identified as "US 1004", is being assigned for the first time. The context for this task is to edit a Job Opening.

## 2. Requirements

**US 1009** As Customer Manager, I want to edit a job opening.

**Acceptance Criteria:**
- 1009.1. The system should edit successfully an attribute of Job Opening. 
- 1009.2. The system should select a valid Job Opening.

**Dependencies/References:**

- N/A

## 3. Analysis

### Business Rules

- This US is directly related to the users of the backoffice.
- To edit a Job Opening the user must be a customer manager.
- The user must have an email, name, and password.
- The job opening must be identified by a job reference.

## 4. Design

### 4.1. Realization

![SD](SD/SD.svg)

### 4.3. Applied Patterns

In the development of this task, we utilized several design patterns to structure our code and ensure its
maintainability and scalability. These patterns include:


- **Repository Pattern:** The Repository pattern was used to create an abstraction layer between the data access layer
  and the business logic layer of the application. This helps to decouple the application and make it easier to maintain
  and test.
- **Controller Pattern:** The Controller pattern was used in the presentation layer of the application. Controllers
  handle incoming requests, manipulate data using the model, and select views to render to the user

### 4.4. Tests

**Test 1:** *Verifies that is possible to edit an attribute of a Job Opening*

**Refers to Acceptance Criteria:** 1009.1

```
@Test(expected = success)
public void ensurePossibleToEditAnAttributeOfJobOpening() {
        JobOpening jobOpening = new JobOpening(...);
        // Attribute example: a Description
        Description newDescription = Description.valueOf(...);
        jobOpening.editDescription(newDescription);
}
```

**Test 2:** *Verifies that it is not possible to edit a invalid Job Opening*

**Refers to Acceptance Criteria:** 1009.2


```
@Test(expected = NullPointerException.class)
public void ensureNotPossibleToSelectAJobRequirementSpecificationForAInvalidJobOpening() {
	JobOpening jobOpening = null;
	// Attribute example: a Description
        Description newDescription = Description.valueOf(...);
        jobOpening.editDescription(newDescription)
}
````

## 5. Implementation

The process of editing a Job Opening in this system involves several components working together. Here's a step-by-step
explanation

- **User Interface (EditJobOpeningUI.java)**: The process starts in the EditJobOpeningUI class, which is
  responsible for interacting
  with the user. It prompts the user to enter the necessary information.
  This class uses the EditJobOpeningController to handle the business logic.
- **Controller (EditJobOpeningController.java):** The EditJobOpeningController class is the bridge between the
  UI and the business
  logic.
- **Repository (JobOpeningRepository):** The JobOpeningRepository is an interface that defines the methods for
  interacting with the
  database. It extends the DomainRepository interface, which provides methods for basic CRUD operations.

## 6. Integration/Demonstration

### Demonstration

To demonstrate the functionality follow the steps below:

#### Edit the working mode of a Job Opening

1. Start the application and log in as a customer manager.
2. Navigate to the job openings section and select the option to edit a Job Opening.
3. Select the Job Opening.
4. Select the working mode attribute to edit.
5. Select the new working mode.

#### Edit the number of vacancy of a Job Opening

1. Start the application and log in as a customer manager.
2. Navigate to the job openings section and select the option to edit a Job Opening.
3. Select the Job Opening.
4. Select the number of vacancy attribute to edit.
5. Input the new number of vacancy.

#### Edit the postal address of a Job Opening

1. Start the application and log in as a customer manager.
2. Navigate to the job openings section and select the option to edit a Job Opening.
3. Select the Job Opening.
4. Select the postal address attribute to edit.
5. Input the new postal address.

#### Edit the Description of a Job Opening

1. Start the application and log in as a customer manager.
2. Navigate to the job openings section and select the option to edit a Job Opening.
3. Select the Job Opening.
4. Select the description attribute to edit.
5. Input the new description.

#### Edit the Function of a Job Opening

1. Start the application and log in as a customer manager.
2. Navigate to the job openings section and select the option to edit a Job Opening.
3. Select the Job Opening.
4. Select the function attribute to edit.
5. Input the new function.

#### Edit the Contract Type of a Job Opening

1. Start the application and log in as a customer manager.
2. Navigate to the job openings section and select the option to edit a Job Opening.
3. Select the Job Opening.
4. Select the contract type attribute to edit.
5. Select the new contract type.

## 7. Observations

- Nothing to add.