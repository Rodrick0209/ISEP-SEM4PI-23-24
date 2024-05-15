# US 1013 - As Customer Manager, I want to rank the candidates for a job opening.

## 1. Context

This task, identified as "US 1013", is part of the Customer Manager feature. The goal of this task is to allow the customer manager to rank the candidates for a job opening.

This is the first task that is directly related to the rank feature of the system.

## 2. Requirements

**1013** As Customer Manager, I want to rank the candidates for a job opening.

**Dependencies/References:**<a id="dependencias"></a>

This user story have some dependencies with the following user stories:


| US                                       | reason                                                                                                                                          |
|------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------|
| [G007](../../SprintB/g007/readme.md)     | Whe need the authentication to ensure is a customer manager that is logged                                                                      |
| [1002](../../SprintB/us1002/readme.md)   | Each Job Opening has its rank, so we need jobOpening in the system                                                                              |
| [2000a](../../SprintB/us2000a/readme.md) | The rank is related do applications, but to exist an application we need the candidate, do its indirectly related                               |
| [2002](../../SprintB/us2002/readme.md)   | This us is responsible for adding applications in the system                                                                                    |
| [1007](../../SprintB/us1007)             | This US is responsible for creating the phases of a job opening. Since ranking can only be done in the 'Analysis' phase, these USs are related. |


# adicionar dependencia para interview e requirements

## 3. Analysis

### What is asked?

the customer manager after analyzing the applications for a job Opening, should be able to rank the candidates. 
The customer manager should attribute a rank number to each job application, the number must be unique.
This process can only be done in the Analysis phase of the job opening.

#### How the number of the rank works?

- The rank is a number that represents the position of the candidate in the job opening.
- The numbers should be sequential, being the first candidate ranked with 1, the second with 2, and so on.
- The rank size list is the same as the number of applications in the job opening that are in *accepted* state 
in the Analysis phase.
- The number of the rank is unique for each job application.


#### How the analysis is done?

- During the recruitment process, in the phase of Analysis, the applications 
are analyzed and the customer manager can rank the candidates. 
The analysis is done considering all available information like interviews, 
curriculum, requirements answer and all files imported from [File Bot](../../SprintB/us2002/readme.md).


#### How the ranking is done?

- 


### Domain model

### Client Clarifications


### Doubts for the client

- **15-05-2024**
  - Rank the candidates for a job Opening is the same as rank the job Applications for a Job Opening, knowing that I can only know the candidates throw the job application? 

  - How is the ranking done? The customer manager selects a job opening and is shown the different candidates, and they assign a rank to each one. And the ranking process end when he assigns a rank to all candidates?

        Example: 
                - Rank the candidate1:
                - Write the rank: 3
            
            
                - Rank the candidate2:
                  - Write the rank: 1
            
            
                - Rank the candidate3:
                  - Write the rank: 4

  - When a customer manager starts the ranking process, he can stop and continue later? Or the ranking process must be done in one go?  
  - The customer manager can change the rank of a candidate after assigning it?
  


### SSD

### How is supposed to work?

### Dependencies to other user stories
- [Tabela de dependencias](#dependencias)

### How to test?

### How to implement?






## 4. Design


### 4.1. Realization



### 4.2. Class Diagram


### 4.3. Applied Patterns



### 4.4. Tests





## 5. Implementation

## 6. Integration/Demonstration

### Integration


### Demonstration



## 7. Observations

