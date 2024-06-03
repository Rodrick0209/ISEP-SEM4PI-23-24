# US 1020 - As Customer Manager, I want to publish the results of the selection of candidates for a job opening, so that the candidates and customer are notified by email of the result.

## 1. Context

This task, identified as "US 1020", is part of the Customer Manager feature. The goal of this task is to allow the customer
manager to publish the results of the selection of candidates for a job opening, so that candidates and the customer are
notified by email of the result.

## 2. Requirements

### 2.1. Acceptance Criteria

- 1. The system should notify the results of the selection of candidates for a job opening.

### 2.2. Dependencies/References

- NFR10 - RCOMP
- NFR11 - RCOMP
- US1013 - As Customer Manager, I want to rank the candidates for a job opening.

### 2.3. Client clarifications

#### 2.3.1. General questions

- **Q48**: Relativamente ao envio das notificações por email, é necessário guardar que esse envio foi feito?
- **A48**: No documento nada de No documento nada de explicito é dito sobre este assunto. No entanto, do ponto de vista de
  gestão do processo da jobs4u parece-me adequado que essa informação fique registada.

- **Q51**: Qual é o formato para essa publicação?
- **A51**:A publicação refere-se a informar os candidatos e o cliente, por email. Os candidatos que são selecionados
  devem receber um email a indicar que para a sua candidatura ao job opening foram selecionados e irão ser contactados pela empresa.
  No que se refere à empresa, esta deve receber um email com a lista dos candidatos selecionados que deve incluir o nome e dados de contacto do candidato.

- **Q190**: Regarding the selection of candidates, should we assume that the first N candidates in the ranking
  (where N is the number of job vacancies) are chosen, or should we allow the customer manager to select the N candidates?
- **A190**: The first option (using the results from US1013).

- **Q224**: Esta US pede que seja publicado os resultados das candidaturas, a minha pergunta seria se este processo só
  pode acontecer quando a job opening estiver encerrada ou se executar esta operação terminaria a job opening.
- **A224**: Esta US é relativa à última fase do processo. Se as notificações executarem todas com sucesso em princípio
  já não existe mais nada a fazer neste processo.


## 3. Analysis

### What is asked?

The task requires implementing a feature for the customer manager to publish the results of the selection of candidates
for a job opening, so that candidates and the customer are notified by email of the result. The selection of candidates
must be based on the current ranking of the Job Opening. The email directed to the candidates must inform them that they
were selected and that they will contacted soon by the Company they applied to.

This feature must comply with specific technical requirements, including a client-server architecture where the client accesses data through a server application.
Additionally, the solution must be deployed on multiple network nodes, with separate nodes for the database server and Follow-Up Server,
ideally in the cloud, ensuring background execution of email notifications. The SMTP application protocol must be used 
to send the email messages trough the SMTP server with DNS name frodo.dei.isep.ipp.pt.

### Domain model

This user story will change the domain model adding and Email Notification to the Domain.

### How is it supposed to work?

After booting up the BackOffice Application, the Customer Manager should be able to publish the results of the selection of candidates for a job opening.
To achieve this, the Customer Manager must follow the steps below:
1. Access the system as a Customer Manager.
2. Access the Job Openings Menu.
3. Select the option to publish of a Job Opening.
4. Selects the Job Opening he wants to publish the results.
5. The system should notify by email the results of the selection of candidates for the job opening.

### SSD

![s](SSD//ssd.svg)

### Impact in the business

These implementations will allow the customer manager to publish the results of the selection of candidates for a job opening,
and automatically notify the candidates and the customer of the result. This will make the process more efficient and transparent,
and will help to keep all parties informed of the status of the job opening.





