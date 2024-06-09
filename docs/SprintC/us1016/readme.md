# US 1016 - As Costumer manager, I want the system to notify candidates, by email, of the result of the verification process

## 1. Context

This task, identified as "US 1016", is part of the Customer Manager feature. The goal of this task is to allow the customer manager
to automate the notification of the result of the verification process to the candidates.

## 2. Requirements

### 2.1. Acceptance Criteria

- 1. The system should notify the candidates, by email, of the result of the verification process.

### 2.2. Dependencies/References

- US 1015 - As Customer Manager, I want to execute the process of verification of requirements of applications for a job opening.
- NFR11 - RCOMP

### 2.3. Client clarifications

#### 2.3.1. General questions

- **Q48**: Relativamente ao envio das notificações por email, é necessário guardar que esse envio foi feito?
- **A48**: No documento nada de explicito é dito sobre este assunto. No entanto, do ponto de vista de gestão do processo 
da jobs4u parece-me adequado que essa informação fique registada.

- **Q69**: Qual é o processo através do qual essa notificação é gerada?
- **A69**: A US1015 permite que o Customer Manager invoque o processo de verificação de requisitos. Depois disso todas 
as candidaturas devem estar aceites ou recusadas. É então possível ao Customer Manager invocar a notificação através da US1016.

- **Q209**: A fase de verificação de requisitos é o mesmo que a fase de traigem?
- **A209**: Sim.

  - **Q210**:  This user story has a functional dependency with 1015. I would like to know if an error occurs, do I need 
  to delete what happened in US 1015, as if it were a transaction?
- **A210**: The process of notification (US1016) must be done after the verification (US1015) but an error in the notification 
does not invalidate the “results” of the verification process. 

## 3. Analysis

### What is asked?

The task requires implementing a feature for the system to notify the candidates, by email, of the result of the verification
process done by the customer manager.

This feature must comply with specific technical requirements, including a client-server architecture where the client accesses data through a server application.
Additionally, the solution must be deployed on multiple network nodes, with separate nodes for the database server and Follow-Up Server,
ideally in the cloud, ensuring background execution of email notifications. The SMTP application protocol must be used
to send the email messages trough the SMTP server with DNS name frodo.dei.isep.ipp.pt.

### Domain model

This user story will change the domain model adding and Email Notification to the Domain.

### How is it supposed to work?

The customer manager should be able to notify the candidates, by email, of the result of the verification process.
The result of the verification process is done in the US 1015.
After that the Customer Manager can invoke the notification process through the US 1016:

1. The Customer Manager selects the job opening Menu.
2. The Customer Manager selects the Notification Menu.
3. The Customer Manager selects a job Opening.
4. The System Notifies the candidates, by email, of the result of the verification process.


### SSD

![s](SSD//ssd.svg)

### Impact in the business

This implementation will allow the customer manager to automate the notification of the result of the verification process
to the candidates, making the process more efficient and less error-prone.

## 4. Design


### 1. Protocol Description


- **TCP-based Client-Server Protocol**: This protocol uses TCP (Transmission Control Protocol) to establish a connection between the client and server applications. The client initiates the connection using the server's IP address or DNS name and the specified TCP port number.
- **Connection Establishment**: After the TCP connection is established, the client and server exchange messages in the specified format. The connection remains open for ongoing data exchanges while the client application is active.
- **Message Exchange Pattern**: The communication follows a strict client-server pattern where the client sends a request and the server replies with a response.


### 2. Communication Protocol

- **Native Sockets**: Communication is done through native sockets and the content of the messages is always encoded as an array of bytes.
  Data is formatted as array of bites, with non-numeric values translated to their byte value (ASCII code in the case of Strings and Chars).
- **Message Types**: The protocol supports this type of messages:

  - `NOTIFYCANDIDATES`


- **Message Format**: The messages are formatted as an array of bytes, with the first byte representing the message version and the second representing the type of message.
  The following bytes representing the message content. Each data field is preceded by two bytes indicating the field size.

| BYTE                                                                   | DESCRIPTION |
|------------------------------------------------------------------------|-------------|
| 0                                                                      | VERSION     |
| 1                                                                      | TYPE        |
| 2                                                                      | DATA1_LEN_L |
| 3                                                                      | DATA1_LEN_M |
| 4 TO 4 + DATA1_LEN_L + DATA1_LEN_M * 256                               | DATA1       |
| DATA1_OFFSET + 1                                                       | DATA2_LEN_L |
| DATA1_OFFSET + 2                                                       | DATA2_LEN_M |
| DATA1_OFFSET + 3 TO DATA1_OFFSET + 3 + DATA2_LEN_L + DATA2_LEN_M * 256 | DATA2       |
| ...                                                                    | ...         |

- **Message Codes**

These are the message code relevant to this user story:

| CODE | DESCRIPTION      |
|------|------------------|
| 0    | COMMTEST         |
| 1    | DISCONN          |
| 2    | ACK              |
| 3    | ERR              |
| 4    | AUTH             |
| 88   | NOTIFYCANDIDATES |


- **Client Connection Handling**: To maintain a good client connection, the client must send a `DISCONN` message before closing the connection.

### 3. Error Handling

- **ERR Message**: The server sends an `ERR` message to the client when an error occurs. The message contains a description of the error.

- If the server does not understand the message it will reply with an `UNKNOWN_REQUEST` message which has the following format:


    UNKNOWN_REQUEST, «request»

- Where `request` is the content the server has received. For instance, if the server receives a message `JOB_APPLICATIONS_REQUEST user1`, it will reply with


    UNKNOWN_REQUEST, "JOB_APPLICATIONS_REQUEST user1"

- If there is a syntax error on the request, that is, the request is known but does not conform to the specification, the server will reply with:


    ERROR_IN_REQUEST, «request», «error-description» 


- If there is a semantic error on the request (e.g., unknown user id), the server will reply with


    BAD_REQUEST, «request», «error-description»

- If there is a problem executing the request (e.g., the server cannot execute the action), the server will reply with


    SERVER_ERROR, «request», «error-description»

### 4. NOTIFYCANDIDATES

The NOTIFYCANDIDATES message has the following format

    NOTIFYCANDIDATES, «job reference»

Where `candidate_email` is the email of the candidate that wants to list his job applications.

#### 4.1 Server Response

The server will reply with a `DATA` message containing the list of job applications and their state including the number of applicants

### 5. Use case realization

This responsibility will be assigned the `backoffice` application since all the existing applications are for user interaction, while this one does not require user interaction.


For this user story we will use the `NotifyCandidatesVerificationProcessController`, this allows to list all the job openings and select which one to notify the candidates of the results.
This controller will be used in the `backoffice` application of the project.

The server must be resilient to badly formed input as well as abrupt connection closing from the client.

The protocol parsing and command execution will be in the `FollowUp` application of the project using a proxy that connects the `backoffice` application to the server.

The server receives the request, parses it, and calls the EmailService. The EmailService will send the email notification to the candidates.

#### 5.1 SD

![s](SD//SD.svg)

### 6. Tests

We will leave the threading part out of scope and will focus on the `BookingProtocolMessageParser` and `BookingProtocolRequest` classes.
the only way ot test the functionality of this user story is to test the email sending, so we will focus on that,
so with that in mind, its impossible to create unit tests for this user story.


## 5. Implementation

For the implementation we had to create some components and use others already created:

- **User Interface (NotifyCandidatesVerificationProcessUI.java):** This component is responsible for the interaction with the user.
- **Controller (NotifyCandidatesVerificationProcessController.java):** This component is responsible for get the job openings and select which one to notify the candidates of the results. It receives the job reference and passes it to the service layer for processing. It also handles the response from the service layer and send the response back to the UI.
- **Repository (JobOpeningRepository):** The JobOpeningRepository class is responsible for keeping the data of the JobOpenings.
- **Repository (JobApplicationRepository):** The JobApplicationRepository class is responsible for keeping the data of the JobApplication, needed for the candidates email.
- **Repository (NotificationRepository):** The NotificationRepository class is responsible for keeping the data of the Notifications, used to keep records of the notifications sent.
- **Service (SelectCandidatesService.java):** The SelectCandidatesService class is where the business logic for selecting the candidates to notify resides.
- **Service (EmailService.java):** The EmailService class is where the business logic for sending the email notifications resides.
- **Server (Followup Server):**: This user story works throw a server, all the connections to de database passes throw the server. 
The backoffice app doesnt have access to email services nor the DNS, so the server is responsible for handling the email sending.

## 6. Integration/Demonstration

### Integration

To integrate the components, we need used some components that already exist in the system, like repositories. The integration of this components with the new components was not very clear and easy to do, because the new ideia of server,
where all data that goes to and comes from database passes throw the server. This integration was hard to understand and implement.
With that said everything was implemented.

### Demonstration

To demonstrate the implementation of this user story, we can use the following steps:

1. Start the application and log in as a customer manager.
2. Navigate to the job opening section and select the option to notify the candidates of the results of the verification process.
3. Select the job opening that has the verification process done.
4. The system will notify the candidates, by email, of the result of the verification process.
5. Check the email of the candidates to see the notification.



