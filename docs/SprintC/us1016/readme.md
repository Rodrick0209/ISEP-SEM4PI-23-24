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


### SD

![s](SSD//ssd.svg)

### Impact in the business

This implementation will allow the customer manager to automate the notification of the result of the verification process
to the candidates, making the process more efficient and less error-prone.

