# US 2024 -As Operator, I want to upload a text le with the data elds (requirements ) of a candidate for its verication.

## 1. Context

This task, identified as "US 2024", is part of the Operator feature. The goal of this task is to allow the operator to add a file with the requirement of a candidate to our system.

## 2. Requirements

### 2.1. Client clarifications


#### 2.1.1. General questions

- **Q15** É o Operador que regista uma candidatura ou é o sistema que o faz automaticamente? E como integra o “plugin” de verificação da candidatura neste processo?
- **A15** Na US 2002 o Operator regista a candidatura. Para isso, é o Operator que inicia o processo mas o sistema deve importar os dados resultantes do Application File Bot de forma “automática” (Ver References da US 2002). O plugin referido entra neste processo através da US 2003, em que o Operador gera um ficheiro template com os dados a introduzir para validar uma candidatura. Na US 2004, o Operador, após preencher os dados específicos da candidatura (com base no ficheiro template anterior) submete no sistema esse ficheiro que vai ser usado para o sistema avaliar/verificar a candidatura. Se os critérios não forem atingidos a candidatura é recusada.

- **Q102** Quem vai preencher as respostas no ficheiro template?
- **A102** Será o Operador e, no âmbito da US2004, este submete o ficheiro já preenchido no sistema.

- **Q119** Management of screening data - We have a question about the management of the screen phase of the recruitment process. Specifically, after the applications are filtered during the screening process, I'm unsure about who manages the results and oversees this phase. Could you please clarify if the responsibility for managing the screening results falls under the customer manager, the operators, or both?
- **A119** In US2003 and US2004 it is the Operator that “downloads” a template file to register the requirements, registers the answers for the requirements in the file, and then uploads the file. It is then the Costumer manager that executes the verification process (US1015) and executes the notification of the results (US1016)

- **Q132** Usage of ANTLR- Is it possible to clarify the usage of ANTRL within user story 2003? You've stated in Q15, Q102 and Q119, that US2003 simply generates the file, while in US2004 the Operator defines the answers and uploads the file. Where is this file uploaded to? Given this, where is the usage of ANTRL in US2003 directed to?
- **A132** Regarding the first question, although difficult it is possible to generate the template text file using ANTLR. If so, there we have the usage o ANTLR. Although, unless there is some specific evaluation requirement from LPROG, it is acceptable that the template file is hardcoded in the plugin (no need for any “complex” generation process/function). Regarding the second question, the file is uploaded to the system. The last question was answered first

- **Q166** Requirements Answers - I'm having trouble understading where are the requirements answer obtained from the candidates, so that the operator can then register their answers in the template previously generated and submit them to the system. Are these answers already within the files processed by tge application fie bot?
- **A166** Please see Q15, Q102, Q119 and Q123. We can assume that the operator has access to all the files submitted by the candidates (since he/she is the one that imports the files into the system – US2002). He/she can than consult these files in order to answer the questions in the requirements template file. She/he then submits the file with the answers (US2004)

- **Q180** Candidate Answers - Does US2004 only deals with the upload of the file to the system or also the registration of the candidate's answer by the Operator? I've seen many mentions about the file's answers but I want to understand if that aspect is also part of US2004.
- **A180** In US2003 the Operator downloads a template file that he/she uses to register the candidate requirements. In US 2004, the Operator uploads a file with the requirements and the system should validate the file (verify of the syntax is correct). US 1015 is the one that executes the verification of requirements for the candidates (based on the previously uploaded files).


## 3. Analysis

The Operator will register a file with the requirements of a candidate. 
The file will be filled by himself accordingly with the date of the application information.

## 4. Design

### 4.1. Domain Classes

-JobApplication
-RequirementAnswer
-RequirementResult

### 4.2 Controller

- **RegisterCandidateRequirementsFile**

### 4.3 Repository

- **JobApplicationRepository**

### 4.4 Methods Implemented

- **RegisterRequirementAnswer()**: Method that associate the fileName to the respective candidate requirement answer.
- **InputStream inputStreamFromResourceOrFile()**: This method should return an InputStream from a file or resource. The file or resource should be passed as a parameter. If the file or resource does not exist, the method should return null.


### 4.5 Strategy Used

For this Us we registered the file name associated with the candidate requirement answer. With this file name we can return an input stream of the file through the method inputStreamFromResourceOrFile() in the class Requirement Answer.


## 5. Tests

- **testIsRecognisingFileAnswer**
- **testDoesntRecogniseInvalidFile**

## 6. How to Use

Manually we add a text file with the requirements from the candidate to the resouces of that core module. Then we can use the UI upload candidate responses file which will ask the file name and the candidate which it will be associated with.  