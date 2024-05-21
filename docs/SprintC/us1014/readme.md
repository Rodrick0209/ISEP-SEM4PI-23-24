# US 1014 - As Customer Manager, I want to record the time and date for an interview with a candidate.

## 1. Context

This task, identified as "US 1014", is part of the Customer Manager feature. The goal of this task is to allow the
customer manager to record the time and date for an interview with a candidate.

This task is directly related to the recruitment process feature of the system, more precisely with the interview phase.

## 2. Requirements

**1014** As Customer Manager, I want to record the time and date for an interview with a candidate.

**Dependencies/References:**<a id="dependencias"></a>

This user story have some dependencies with the following user stories:

| US                                       | Reason                                                                                                                                                                                                                                                    |
|------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| [G007](../../SprintB/g007/readme.md)     | We need the authentication to ensure is a customer manager that is logged                                                                                                                                                                                 |
| [1002](../../SprintB/us1002/readme.md)   | The interview will take place due to a  job opening, therefore there must be a job opening in the system                                                                                                                                                  |
| [1005](../../SprintB/us2000a/readme.md)  | The costumer manager will need to choose between the applications for a job opening so then he could setup an interview with the candidate that made the application. Since in us1005 the applications for a job opening are listed, the us´s are related |
| [2000a](../../SprintB/us2000a/readme.md) | We need a candidate for the job opening to interview, therefore we need candidate(s) registered in the system                                                                                                                                             |
| [2002](../../SprintB/us2002/readme.md)   | The candidate that is being interviewed must have applied for the job opening in question                                                                                                                                                                 |
| [1007](../../SprintB/us1007)             | This US is responsible for creating the phases of a job opening. Since we want to record a time and a date for an interview wich corresponds to the 'Interview' phase, these USs are related.                                                             |

## 3. Analysis

### What is asked?

The customer manager must be able to set a time and date for an interview with a candidate for a job opening.

To schedule an interview with a candidate, the candidate must have passed the screening phase, although the interview
may be scheduled before we know whether the same has happened.

Two interviews can take place simultaneously.

#### 1. How does setting a date for an interview work?

- The customer manager selects the job opening that he wants to schedule an interview.
- He will then proceed to choose the application of the candidate he wants to schedule an interview with.
- It will then be possible to associate an interview with the job application with the respective date and time.
- When choosing a date there will be a confirmation with the day of the week of the date chosen

#### 2.How does setting a date for an interview work in the system ?

- There will be a verification if an interview will take place or not
- If so the user will have the possibility to schedule a date
- A date will then be associated to the job application

### Domain model

To implement this user story there will be no changes needed to the domain model

- The entity Job Application will have his value object "Interview" changed
- The value object interview will have the value objects "date" and "time" changed

![domain_model.jpeg](..%2Fus1013%2Fimg%2Fdomain_model.jpeg)

### Doubts to the client

- Uma entrevista pode ter apenas uma questão? US1014, time and date, quer dizer data de inicio e não data final? Podem
  haver entrevistas em paralelo?

  > **Answer:** Quanto ao número de perguntas numa entrevista, não está definido nenhum limite inferior ou superior. Ou
  seja, pode haver uma entrevista com apenas 1 pergunta (não fará sentido não ter perguntas). A US1014 refere-se à
  marcação da data de uma entrevista com um candidato. Algo como indicar o dia e a hora (ex: 23 de abril pelas 14:00).
  Em relação à marcação de entrevistas “sobrepostas” (com a mesma data de inicio), neste momento, seria algo a
  permitir (pode, por exemplo, o customer manager delegar noutra pessoa a condução da entrevista). Isso não invalida que
  devam validar se as entrevistas ocorrem dentro da fase das entrevistas.


- Em relação à marcação da intervista, só deve ser possível marcar esta data quando? Só será possível marcar a
  entrevista quando a fase de recrutamento se encontrar na fase de intervista? Ou será possivel marcar noutras fases
  anteriores?

> **Answer:** Por mim pode ser possível marcar as entrevistas antes mas deve-se ter em atenção se o candidato “passou” o
> screening. Não faz sentido marcar uma entrevista para um candidato que não foi aceite. Tenham em atenção este tipo de
> aspetos.

- In the us "US 1014 - As Customer Manager, I want to record the time and date for an interview with a candidate." Is it
  possible to schedule interviews for any day and time or we must take into account weekends, working hours and
  holidays, for example?

> **Answer:** The system should display the day of the week for the selected date. But the system should accept any
> valid date.

### Client Clarifications

These clarifications were made with the client to better understand the requirements of the user story. All questions
and aswers are available in
this [file](https://myisepipp-my.sharepoint.com/:w:/g/personal/atb_isep_ipp_pt/EUuTReNeiM1NorupBbiS9hQB38kUh5TPLca7uDYEitSeZg?e=I5ymVX).

- There may be interviews to take place at the same time for the same job opening
- Interviews can be scheduled at any time, however, they will only happen if the candidate in question has passed the
  screening phase
- The system should display the day of the week for the selected date.
- The system should accept any valid date

### How is supposed to work?

To record a time and date for an interview with a candidate you should follow the next steps:

1. The user should be logged in as a Customer Manager.
2. The customer manager selects the Job Opening option, and then one option to choose an application from the job
   opening.
3. The system will show to the customer manager all the job applications that passed the Screening phase and will have
   an interview ocurring in the future.
4. The customer manager selects the job application in wich he wants to schedule an interview.
5. He will then be asked to choose a time and a date for the interview.
6. Finaly the system will confirm with the user the date (with the day of the week) and the time chosen by the customer manager.



### SSD

![ssd](SSD/ssd.svg)

### Dependencies to other user stories

- [Dependencies table](#dependencias)

### Impact in the business

- After ranking is done, the customer can access to the list of candidates in the order that the customer manager thinks
  is the best for the job opening. This can be a good way to help the customer to select the best candidate for the job
  opening.

## 4. Design

### 4.1. Realization

![sd](SD/sd.svg)

### 4.2. Class Diagram

![CD](CD/CD.svg)

### 4.3. Applied Patterns

- **Repository Pattern:** Repository Pattern is an essential for managing data access in a way that promotes clean
  separation of concerns, flexibility, and testability.


- **Service Pattern:** The Service Pattern is an essential for organizing business logic in a scalable, maintainable,
  and reusable way. By implementing a service layer, applications can achieve a clean separation of concerns, making
  them easier to develop, test, and maintain.


- **Controller Pattern:** Is essential for managing the interaction between the user interface and the business logic of
  an application. By clearly separating concerns into models, views, and controllers, applications become more modular,
  easier to develop, test, and maintain.

### 4.4. Tests

#### 4.4.1. Unit Tests

##### Rank Class

- **Test 1:** Test set rank only works with rankSize set first
- **Test 2:** Test create a rank with a list of candidates
- **Test 3:** Test create a rank with a list of candidates with a size bigger than the rank size list
- **Test 4:** Test create a rank with a list of candidates with a size smaller than the rank size list
- **Test 5:** Test the ToString method

#### 4.4.2. Integration Tests

- **Test 1:** Test adding a candidate that doest exist
- **Test 2:** Test adding a candidate that exist but didn't applied for that jobOpening
- **Test 3:** Test adding a candidate that exist and applied for that jobOpening
- **Test 4:** Test writing a rank with invalid emails
- **Test 5:** Test writing a rank with valid separator
- **Test 6:** Test writing a rank correctly

## 5. Implementation

## 6. Integration/Demonstration

### Integration

### Demonstration

## 7. Observations

