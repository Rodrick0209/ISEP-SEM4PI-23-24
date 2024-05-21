# US 1017 - As Customer Manager, I want to upload a text le with the candidate responses for an interview.

## 1. Context

This task, identified as "US 1010", is part of the Customer Manager feature. The goal of this task is to allow the customer manager to add a file with the candidate answer to our system.

## 2. Requirements

### 2.1. Client clarifications

#### 2.1.1. General questions

- **Q2**: As entrevistas são feitas presencialmente? Se sim, quem é responsável por registar essas respostas no sistema?
- **A2**: O meio usado para as entrevistas está fora do âmbito do sistema. Podem ser presenciais, remotas (ex: telefone ou outro meio). Independentemente do meio, o Customer Manager é o responsável por registar as respostas no sistema, através da submissão (upload) do ficheiro de texto com as respostas do candidato. 

## 3. Analysis

User will be able to upload a text file with the responses from the candidate to the resouces of that core module. Then the customer manager should have a functionality to attribute the file to the respective candidate.

## 4. Design

### 4.1. Domain Classes

-AnswerFileName
-Interview

### 4.2 Controller

- **RegisterCandidateFileWithAnswersToInterviewController**

### 4.3 Repository

- **JobApplicationRepository**

### 4.4 Methods Implemented

- **RegisterInterviewAnswer()**: Method that associate the answerFileName to the respective candidate interview.
- **InputStream inputStreamFromResourceOrFile()**: This method should return an InputStream from a file or resource. The file or resource should be passed as a parameter. If the file or resource does not exist, the method should return null.


### 4.5 Strategy Used

For this Us we registered the file name associated with the candidate interview. With this file name we can return an input stream of the file through the method inputStreamFromResourceOrFile() in the class Interview.


## 5. Tests

- **testIsRecognisingFileAnswer**
- **testDoesntRecogniseInvalidFile**

## 6. How to Use

Manually we add a text file with the responses from the candidate to the resouces of that core module. Then we can use the UI upload candidate responses file which will ask the file name and the candidate which it will be associated with.  