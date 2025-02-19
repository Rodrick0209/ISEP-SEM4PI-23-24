# US 1019

## 1. Context

This task, identified as "US 1019", is part of the Customer Manager feature. The goal of this task is to allow the customer manager to get an ordered list of candidates, using the interview points (grades), to analyze the candidates.

## 2. Requirements

**1019** As Customer Manager, I want to get an ordered list of candidates, using the job
interview points (grades), to help me analyze the candidates.

**Dependencies/References:**

This user story have some dependencies with the following user stories:

| US                                                                     | Reason                                                                                  |
|------------------------------------------------------------------------|-----------------------------------------------------------------------------------------|
| [G007](../../SprintB/g007/readme.md)                                   | We need the authentication to ensure is a customer manager that is logged.              | 
| [1002](../../SprintB/us1002/readme.md)                                 | The job opening must be registered in the system.                                       |
| [1007](../../SprintB/us1007/readme.md)<br/>[1010](../us1010/readme.md) | The job must must had received applications, so that one of the phases happened.        |
| [1009](../../SprintB/us1009/readme.md)                                 | The job opening must have a requirement specification made for evaluating requirements. |
| [1011](../../SprintB/us1011/readme.md)                                 | The job opening must have a interview model made for evaluation.                        |
| [1012](../../SprintC/us1012/readme.md)                                 | The job application must have a requirement answer.                                     |
| [1014](../../SprintC/us1014/readme.md)                                 | The candidate of a job application had an interview with a customer.                    |
| [1015](../../SprintC/us1015/readme.md)                                 | The job application of a job opening has an result from requirement answer.             |
| [1017](../../SprintC/us1017/readme.md)                                 | The job application of a job opening has an interview answer.                           |
| [1018](...)                                                            | The job application must have interview points.                                         |


## 3. Analysis

- **The customer manager, after evaluating the interviews for a job opening, is able to get an ordered list of candidates of the applications of this job opening, basing in the interview grades.**

### 3.1. Client meeting

**Question:**

- A lista que pretende é relacionada a uma job opening correto? A maneira de ordenação é ascendente ou quer uma opção que inclua ascendente e descendente?

**Answer:**

- Sim, a ordenação é relativa a candidaturas para um job opening. A ordenação deve ser descendente, do que tem maior pontuação para o que tem menor pontuação.

### 3.2. Business rules

- The job opening should currently be in the analysis phase.
- The job opening should have had an interviewing phase.
- The final list should be showed in descending order.

### 3.3. System functionality

![](SSD/SSD.svg)

## 4. Design

### 4.1. Realization

![](SD/SD.svg)

### 4.2. Applied Patterns

In the development of this task, we utilized several design patterns to structure our code and ensure its
maintainability and scalability. These patterns include:

- **Repository Pattern:** The Repository pattern was used to create an abstraction layer between the data access layer
  and the business logic layer of the application. This helps to decouple the application and make it easier to maintain
  and test.
- **Controller Pattern:** The Controller pattern was used in the presentation layer of the application. Controllers
  handle incoming requests, manipulate data using the model, and select views to render to the user.

### 4.3. Tests

**In this case, tests are implemented for all Business Rules**

```
void ensureOrderCandidatesBasedOnInterviewPointsIsSucessfullWhenJobOpeningHadInterviewPhaseAndCurrentlyInAnalysisPhase() (expected = success) {
  JobOpening jobOpening = new JobOpening(...);
  Phase phase1 = new Phase(Phase.INTERVIEW,...);
  Phase phase2 = new Phase(Phase.ANALYSIS,...);
  List<Phase> phases = new ArrayList<>(List.of(phase1, phase2));
  RecruitmentProcesss rp = new RecruitmentProcess(phases);
  rp.currentPhase = phase2;
  rp.previousPhase = phase1;
  Candidate candidate1 = new Candidate(...);
  Candidate candidate2 = new Candidate(...);
  JobApplication jobApplication1 = new JobApplication(jobOpening, candidate1, ...);
  JobApplication jobApplication2 = new JobApplication(jobOpening, candidate2, ...);
  jobApplication1.interview.interviewAnswer.interviewPoints = 30;
  jobApplication2.interview.interviewAnser.interviewPoints = 50;
  List<JobApplication> jobApplications = new ArrayList<>(List.of(jobApplication1, jobApplication2));
  List<Candidate> orderedCandidates = orderCandidatesBasedOnInterviewPoints(jobApplications); 
}
```

```
void ensureOrderCandidatesBasedOnInterviewPointsFailedWhenJobOpeningNotHadInterviewPhase() (expected = IllegalArgumentException.class) {
  JobOpening jobOpening = new JobOpening(...);
  Phase wrongPhase = new Phase(Phase.SCREENING,...);
  Phase phase2 = new Phase(Phase.ANALYSIS,...);
  List<Phase> phases = new ArrayList<>(List.of(phase1, phase2));
  RecruitmentProcesss rp = new RecruitmentProcess(phases);
  rp.currentPhase = phase2;
  rp.previousPhase = wrongPhase;
  Candidate candidate1 = new Candidate(...);
  Candidate candidate2 = new Candidate(...);
  JobApplication jobApplication1 = new JobApplication(jobOpening, candidate1, ...);
  JobApplication jobApplication2 = new JobApplication(jobOpening, candidate2, ...);
  jobApplication1.interview.interviewAnswer.interviewPoints = 30;
  jobApplication2.interview.interviewAnser.interviewPoints = 50;
  List<JobApplication> jobApplications = new ArrayList<>(List.of(jobApplication1, jobApplication2));
  List<Candidate> orderedCandidates = orderCandidatesBasedOnInterviewPoints(jobApplications); 
}
```

```
void ensureOrderCandidatesBasedOnInterviewPointsFailedWhenJobOpeningNotCurrentlyInAnalysisPhase() (expected = IllegalArgumentException.class) {
  JobOpening jobOpening = new JobOpening(...);
  Phase phase1 = new Phase(Phase.INTERVIEW,...);
  Phase wrongPhase = new Phase(Phase.SCREENING,...);
  List<Phase> phases = new ArrayList<>(List.of(phase1, phase2));
  RecruitmentProcesss rp = new RecruitmentProcess(phases);
  rp.currentPhase = wrongPhase;
  rp.previousPhase = phase1;
  Candidate candidate1 = new Candidate(...);
  Candidate candidate2 = new Candidate(...);
  JobApplication jobApplication1 = new JobApplication(jobOpening, candidate1, ...);
  JobApplication jobApplication2 = new JobApplication(jobOpening, candidate2, ...);
  jobApplication1.interview.interviewAnswer.interviewPoints = 30;
  jobApplication2.interview.interviewAnser.interviewPoints = 50;
  List<JobApplication> jobApplications = new ArrayList<>(List.of(jobApplication1, jobApplication2));
  List<Candidate> orderedCandidates = orderCandidatesBasedOnInterviewPoints(jobApplications); 
}
```

## 5. Implementation

The process of editing a Job Opening in this system involves several components working together. Here's a step-by-step
explanation

- **User Interface (GetOrderedListOfCandidatesUI.java)**: The process starts in the GetOrderedListOfCandidatesUI class, which is
  responsible for interacting
  with the user. It prompts the user to enter the necessary information.
  This class uses the GetOrderedListOfCandidatesController to handle the business logic.
- **Controller (GetOrderedListOfCandidatesController.java):** The GetOrderedListOfCandidatesController class is the bridge between the
  UI and the business
  logic.
- **Repository (JobOpeningRepository):** The JobOpeningRepository is an interface that defines the methods for
  interacting with the
  database. It extends the DomainRepository interface, which provides methods for basic CRUD operations.
- **Repository (ClientRepository) (only for editing a client):** The ClientRepository is an interface that defines the methods for
  interacting with the
  database. It extends the DomainRepository interface, which provides methods for basic CRUD operations.
- **Service (GetOrderedListOfCandidatesService.java):** The GetOrderedListOfCandidatesService class is where the business logic for get an ordered list of candidates based on Interview Points resides.

## 6. Demonstration

To demonstrate the implementation of this user story, we can use the following steps:

1. Start the application and log in as a customer manager.
2. Navigate to the candidate section and select the option to get a ordered list of candidates based on interview points.
3. Select the job opening that is in analysis phase and had an interview phase.

## 7. Observations

- N/A