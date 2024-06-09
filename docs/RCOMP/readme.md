# RCOMP - Integrative Project

## Description

For the RCOMP course, it was asked to develop 6 US, following a client-server architecture, and other guidelines.

## Backlog
### US

| User Story | Description                                                                                                                                                              |
|------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 1016       | As Customer Manager, I want the system to notify candidates,by email, of the result of the verification process.                                                         |
| 1020       | As Customer Manager, I want to publish the results of the selection of candidates for a job opening, so that candidates and customer are notified by email of the result |
| 3000       | As Candidate, I want to list all my applications and their state (including the number of applicants).                                                                   |
| 3001       | As Candidate, I want to be notified in my application when the state of one of my applications changes.                                                                  |
| 3002       | As Customer, I want to list all my job openings, including job reference, position, active since, number of applicants.                                                  |
| 3003       | As Customer, I want to be notified in my application when the state (phase) of my job openings changes.                                                                  |

## Application Protocol

### Protocol Description

The Follow-Up Server uses TCP base client-server architecture:

- The client application takes the initiative of establishing a TCP connection with the server
application, for such the client application is required to know (IP address or DNS name) the node
where the server application is running and the TCP port number where the server application is
accepting TCP connections.
- After the TCP connection is established, the connected applications exchange messages with the
format described in Section 4.2.
- Once established, the TCP connection between the client application and the server application is
kept alive and is used for all required data exchanges while the client application is running.
- All message exchanges between the client application and the server application must follow a
very restrict client-server pattern: the client application sends one request message, and the server
application sends back one response message.

### Message Format

The messages are formatted as an array of bytes, with the first byte representing the message version and the second representing the type of message.
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

### Message Codes

| TYPE | NAME                       | DESCRIPTION                                                                                                                                                                        |
|------|----------------------------|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 0    | COMM_TEST                  | Used to test communications, contains no data.(message)                                                                                                                            |
| 1    | DISCONN                    | Used to signal the server that the client is disconnecting. (request)                                                                                                              |
| 2    | ACK                        | Used to answer the client when a request is successful and no data was requested. (resposnse)                                                                                      |
| 3    | ERR                        | Used to signal the client there was an error parsing the request. (response)                                                                                                       |
| 4    | AUTH                       | Authentication request from the client. Answered with an ACK message if sucessful, and ERR message otherwise. (request)                                                            |
| 6    | GET_AVAILABLE_OPN          | Used to request the server for availblke job openings. (request)                                                                                                                   |
| 7    | GET_CUSTOMER               | Used to request the customer data. (request)                                                                                                                                       |
| 8    | GET_NOTIFICATIONS_READ     | Used to request the server for already read notifications. (request)                                                                                                               |
| 9    | GET_NOTIFICATIONS_NOT_READ | Used to request notificaitons that aren't read. (request)                                                                                                                          |
| 11   | GET_APPLICATION_CANDIDATE  | Used to request the data for an application of a Candidate. (request)                                                                                                              |
| 87   | PUBLISHOPN                 | Used to request the server to notify the candidates and the customer of the results of Job Opening, containg in ASCII the Job Reference of that same Job Opening .  (request)      |
| 88   | NOTIFYCANDIDATES           | Used to request the server to notify the candidates of the results of the verificaiton process for a job opening, containg in ASCII the Job Reference of that same Job . (request) |

## Client

The client is a Java application that connects to the server using a TCP connection.
Each Application as Proxy class, that connects and communicates with the server, and a Controller class, that handles the user interface.

For the customer and candidate application, since they dont have direct access to the database, every data request is sent to the server,
which will then query the database and return the requested data.

The Backoffice application has direct access to the database, and can query the database directly. Despite this, the Backoffice application still needs
the server to notify the candidates and customers of the results of the verification process and the job openings, since it doesn't have an Email Service.
The latter is hosted in th FollowUp Server.


## Server

The server is a multithreaded server that listens for incoming connections on a specified port, programmed in Java.
The server is able to handle multiple clients at the same time, and each client is handled by a different thread.

For each message received, the server will parse the message and create an FollowUpRequest object,
which will handle the request and return a new byte array containing the response message.

All messages consist if arrays of bytes, with the first byte representing the message version and the second representing the type of message.
The next two bytes determine the size of the first data field, and the following bytes represent the data itself.

All text is encode in ASCII.

The server is directly connected to the H2 database, which contains all the data needed for the application.

### Server Hosting

Both the serve and the database are hosted in the DEI servers, in two different machines.
To be able to communicate with the server, the client must know the IP address of the server and the port number where the 
server is listening for incoming connections, and be connected to the DEI VPN.
To access the database, the user must also be connected to the DEI VPN.

### Email Service

The server also hosts an Email Service, which is used to send emails to the candidates and customers.
The Email Service is used to notify the candidates and customers of the results of the verification process and the job openings.
Since the Follow-Up Server doesn't have a SMTP server, the Email Service uses the DEI SMTP (frodo.dei.isep.ipp.pt) server to send the emails.










