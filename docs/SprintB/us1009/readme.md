# US 1009

## 1. Context

This task, identified as "US 1009", is being assigned for the first time. The context for this task is to select a Job Requirement Specification for a Job Opening.

## 2. Requirements

**US 1009** As Customer Manager, I want to select the requirements specification to be used
for a job opening.

**Dependencies/References:**

- NFR09(LPROG) - Requirement Specifications and Interview Models The support
  for this functionality must follow specific technical requirements, specified in LPROG.
  The ANTLR tool should be used (https://www.antlr.org/).

## 3. Analysis

### Client meeting

-  O Customer manager regista a job opening (US 1002) e de seguida (normalmente) seleciona qual o requirements specification que é adequado a esse job opening. O requirements specification será um dos que foi “criado” pelo language engineer e registado no sistema.

### Business Rules

- This US is directly related to the users of the backoffice.
- To select a Job Requirement Specification for a Job Opening the user must be a customer manager.
- The user must have an email, name, and password.
- The job requirement specification must be identified by a name.
- The job opening must be identified by a job reference.

## 4. Design

### 4.1. Realization

![SD](SD/SD.svg)

### 4.2. Class Diagram

![CD](CD/CD.svg)

### 4.3. Applied Patterns

### 4.4. Tests

Include here the main tests used to validate the functionality. Focus on how they relate to the acceptance criteria.

**Test 1:** *Verifies that it is not possible to ...*

**Refers to Acceptance Criteria:** G002.1


```
@Test(expected = IllegalArgumentException.class)
public void ensureXxxxYyyy() {
	...
}
````

## 5. Implementation

*In this section the team should present, if necessary, some evidencies that the implementation is according to the design. It should also describe and explain other important artifacts necessary to fully understand the implementation like, for instance, configuration files.*

*It is also a best practice to include a listing (with a brief summary) of the major commits regarding this requirement.*

## 6. Integration/Demonstration

*In this section the team should describe the efforts realized in order to integrate this functionality with the other parts/components of the system*

*It is also important to explain any scripts or instructions required to execute an demonstrate this functionality*

## 7. Observations

*This section should be used to include any content that does not fit any of the previous sections.*

*The team should present here, for instance, a critical prespective on the developed work including the analysis of alternative solutioons or related works*

*The team should include in this section statements/references regarding third party works that were used in the development this work.*