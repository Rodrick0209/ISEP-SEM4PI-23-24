# US 2002

## 1. Context

This task, identified as "US 2002", is part of the Operator Management feature. The goal of this task is to allow the 
operator to register application of candidates by importing automatically from files that candidate send by email and 
were processed by the system.

## 2. Requirements

**US 2002**As Operator, I want to register an application of a candidate for a job opening and
import all files received.



**Dependencies/References:**

- Import the data from the file that was processed by the Application
  File Bot in Req 2001. The files should be kept in the shared folder, but the Backoffice
  application needs to know the references to the file locations.

## 3. Analysis


## Client Meeting

- The Operator registers the application. For this, it is the Operator who initiates the process, but the system must import the data resulting from the Application File Bot in an "automatic" way.
- US2002 is for import of the applications from the data iin the files produced by the application file bot. If the candidate does not exist, it should be created. I think there is no registration of a candidate by the admin.

## Business Rules

- The operator must create applications by files processed by the Application File Bot.
- The candidate must be created if it does not exist.
- The operator must be able to import the data from the files processed by the Application File Bot.

## 4. Design


### 4.1. Realization

![List User](SD/SD.png)


### 4.2. Class Diagram

![List User](CD/CD.png)

### 4.3. Applied Patterns


In the development of this task, we utilized several design patterns to structure our code and ensure its maintainability and scalability. These patterns include:  
- **Builder Pattern:** This pattern was used to construct complex objects step by step. It separates the construction of an object from its representation, allowing the same construction process to create different representations.  
- **Repository Pattern:** The Repository pattern was used to create an abstraction layer between the data access layer and the business logic layer of the application. This helps to decouple the application and make it easier to maintain and test.  
- **Service Pattern:** The Service pattern was used to encapsulate business logic and rules. This pattern provides a set of methods that any client application can use, and these methods implement the business rules and logic.  
- **Controller Pattern:** The Controller pattern was used in the presentation layer of the application. Controllers handle incoming requests, manipulate data using the model, and select views to render to the user



### 4.4. Tests


#### Test #1: Add user successfully
1. 
2. 
3. 




## 5. Implementation
The process of registering a new user in this system involves several components working together. Here's a step-by-step explanation


- **User Interface (RegisterApplicationUI.java):** The process starts in the RegisterApplicationUI class, which is responsible for interacting with the operator. It prompts the operator to select a job opening and a job application. This class uses the RegisterJobApplicationController to handle the business logic.
- **Controller (RegisterJobApplicationController.java):** The RegisterJobApplicationController class is the bridge between the UI and the business logic. It uses the GetApplicationDataService to retrieve job openings and job applications from the report file. It also uses the RegisterCandidateController to register a candidate if they do not exist.
- **Service (GetApplicationDataService.java):** The GetApplicationDataService class is where the actual business logic for retrieving job openings and job applications resides. It reads the report file and returns a list of job openings and job applications. It also retrieves the application files and candidate information from the report file.
- **Repository (JobApplicationRepository and JobOpeningRepository):** These repositories are interfaces that define the methods for interacting with the database. They extend the DomainRepository interface, which provides methods for basic CRUD operations. When a new job application is registered, it creates a new JobApplication object and saves it to the database using the JobApplicationRepository. It also updates the JobOpening object in the database using the JobOpeningRepository


## 6. Integration/Demonstration

### Integration


### Demonstration

To demonstrate the functionality and the handling of invalid inputs, follow the steps below:  
1. Start the application and log in as an operator.
2. Navigate to the  section and select the option to Add a user.
3. In the form that appears, fill the required fields with valid information. 
4. Submit the form. The system displays a success message "User created successfully."
5. To confirm that the user was not created, navigate to the List Users section under Users. The new user with the invalid name should not appear in the list.

This process demonstrates the system's ability to validate user input and successfully create a user with valid details.

## 7. Observations

One observation to note is that the password generated for the new user is not displayed on the screen. The method by which the new user gains access to their password is currently out of the scope of this project. 