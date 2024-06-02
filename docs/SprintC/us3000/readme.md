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




