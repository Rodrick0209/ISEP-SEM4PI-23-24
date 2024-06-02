# US 3000 - As Candidate, I want to list all my applications and their state (including the number of applicants).

## 1. Context

This task, identified as "US 3000", is part of the Candidate feature. The goal of this task is to allow the candidate
to list the applications he has submitted and their state.

## 2. Requirements

### 2.1. Acceptance Criteria

- 1. The system should list all the Job Applications of the candidate an their state.

### 2.2. Dependencies/References

- NFR11 - RCOMP

### 2.3. Client clarifications

#### 2.3.1. General questions

- **Q176**: Na US3000 pede que, para alem de listar as aplicações e o estado das mesmas de um candidato, que liste o 
numero de candidatos. Este numero de candidatos é um somatório da quantidade de candidatos que fizeram uma aplicação para 
as mesmas Job Openings deste primeiro candidato (que esta a executar o caso de uso)?
- **A176**: Devem ser listadas todas as “applications” (candidaturas) do candidato, o estado delas, assim como o número 
de candidaturas que cada job opening teve (assim o candidato tem uma noção da “concorrência” que teve para cada uma das suas candidaturas)

## 3. Analysis

### What is asked?

The task requires implementing a feature for candidates to list all their applications and their state, including the number of applicants.
This feature must comply with specific technical requirements, including a client-server architecture where the client 
accesses data through a server application, without direct database access.
Additionally, the solution must be deployed on multiple network nodes, with separate nodes for the database server and Follow-Up Server, 
ideally in the cloud, ensuring background execution of email notifications.

### Domain model

This user story doesn't have any impact on the domain model.

### How is it supposed to work?

The candidate should be able to list all his applications and their state, including the number of applicants. This information should be accessed by a server.
To achieve this, the candidate must follow the steps below:
1. Access the system as a candidate.
2. Access the Job Applications Menu.
3. Select the option to list all job applications.
4. The system should display a list of all job applications, including their state and the number of applicants.

### SSD
![s](SSD//ssd.svg)

### Impact in the business

These implementations will allow the candidate to have a better overview of his applications, making it easier to manage 
them and have a better understanding of the amount of people applying for the same Job Opening.

## 4. Design

### 1. Protocol Description


- **TCP-based Client-Server Protocol**: This protocol uses TCP (Transmission Control Protocol) to establish a connection between the client and server applications. The client initiates the connection using the server's IP address or DNS name and the specified TCP port number.
- **Connection Establishment**: After the TCP connection is established, the client and server exchange messages in the specified format. The connection remains open for ongoing data exchanges while the client application is active.
- **Message Exchange Pattern**: The communication follows a strict client-server pattern where the client sends a request and the server replies with a response.


### 2. Communication Protocol

- **Native Sockets**: Communication is done through native sockets and the content of the messages is always encoded as an array of bytes.
Data is formatted as array of bites, with non-numeric values translated to their byte value (ASCII code in the case of Strings and Chars).
- **Message Types**: The protocol supports this type of messages:
  
  - `GET_JOB_APPLICATIONS_REQUEST` 
  - `AUTH`
  - `ERR`
  - `ACK`
  - `DISCONN`

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

| CODE | DESCRIPTION                  |
|------|------------------------------|
| 0    | COMMTEST                     |
| 1    | DISCONN                      |
| 2    | ACK                          |
| 3    | ERR                          |
| 4    | AUTH                         |
| 5    | GET_JOB_APPLICATIONS_REQUEST |
| 50   | DATA                         |


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

### 4. GET_JOB_APPLICATIONS_REQUEST

The GET_JOB_APPLICATIONS_REQUEST message has the following format

    GET_JOB_APPLICATIONS_REQUEST, «candidate_id»

Where `candidate_id` is the id of the candidate that wants to list his job applications.

#### 4.1 Server Response

The server will reply with a `DATA` message containing the list of job applications and their state including the number of applicants

### 5. Use case realization

This responsibility will be assigned to a new application (`FollowUpDeamon`) since all the existing applications are for user interaction, while this one does not require user interaction.


For this user story we will use the `CandidateListJobApplicationsController`, this allows to list all the job applications for a candidate.
This controller will be used in the `daemon` application project.

The server must be resilient to badly formed input as well as abrupt connection closing from the client.

The protocol parsing and command execution will be in the `daemon` application project using a new controller from the `core` project.

The server receives the request, parses it, and calls the controller. The controller will return the data to the server,
then it sends the data back to the client.

### 6. SD

![use case](SD//sd.svg)

### 7. Tests

We will leave the threading part out of scope and will focus on the `BookingProtocolMessageParser` and `BookingProtocolRequest` classes.

For `GET_JOB_APPLICATIONS_REQUEST`:
- ensure an `DATA` message is retrieved with the corresponding Job Applications

## 5. Implementation


## 6. Integration/Demonstration

### Integration


### Demonstration



## 7. Observations



