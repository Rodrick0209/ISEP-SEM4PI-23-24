# US 1015 - As Customer Manager, I want to execute the process of verication of requirements of applications for a job opening.

## 1. Context

This task, identified as "US 1015", is part of the Customer Manager feature. The goal of this task is to allow the customer manager to execute the process of verification of requirements of applications for a job opening.

## 2. Requirements

### 2.1. Client clarifications

#### 2.1.1. General questions

- **Q69** Acerca da US 1016 - "As Customer Manager, I want the system to notify candidates, by email, of the result of the verification process" qual é o processo através do qual essa notificação é gerada? Após a avaliação do Requirement Specification module, este gera um resultado "Aprovado" ou "Rejeitado". Este resultado despoleta automaticamente uma notificação para o candidato ou é o Customer Manager que tem a responsabilidade de informar o candidato através do sistema do resultado da verificação (ex. depois de um resultado negativo ser gerado, o Customer Manager vai no sistema rejeitar o candidato para que seja enviado o email)?
- **A69** É a segunda opção que apresenta. A US1015 permite que o Customer Manager invoque o processo de verificação de requisitos. Depois disso todas as candidaturas devem estar aceites ou recusadas. É então possível ao Customer Manager invocar a notificação através da US1016.

- **Q167** Deve ser executado o processo para todos os candidatos ou apenas para alguns (segundo algum critério)?
- **A167** Os ficheiros com as respostas aos requisitos vão entrando no sistema gradualmente. Talvez seja mais “simples” que o processo execute (ou seja, faça a verificação dos requisitos) para os candidatos para os quais já foi submetido o ficheiro de requisitos. Nalgum momento o processo irá executar com todos os candidatos já com os ficheiros de requisitos submetidos.

- **Q210** This user story has a functional dependency with 1015. I would like to know if an error occurs, do I need to delete what happened in US 1015, as if it were a transaction?
- **A210** The process of notification (US1016) must be done after the verification (US1015) but an error in the notification does not invalidate the “results” of the verification process.

- **Q223** About the Us2004, in A180 you previously stated that "the Operator uploads a file with the requirements and the system should validate the file (verify of the syntax is correct). US 1015 is the one that executes the verification...". What should happen if the file failes this verification? Is the application instantly refused or do you have something else in mind?
- **A223** A file that fails the verification means that that file has an error (syntactic error) it does not mean that the application does not meet the requirements. The user should fix the error and submit again. Only US 1015 results in approving or rejecting an application.

## 3. Analysis

- **BR1** The process of verification attribute a result to the application requirements. This result can be "Approved" or "Rejected". 
- **BR2** 

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