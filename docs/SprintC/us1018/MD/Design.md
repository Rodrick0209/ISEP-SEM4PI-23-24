# Design

## Functionality

![](../SD/SD.svg)

## Domain classes

- JobOpening
- JobApplication
- InterviewModelSpecification
- Interview
- RequirementProcess
- Phase

## Controller

- ExecuteInterviewEvaluationController

## Service

- ExecuteInterviewEvaluationService

## Repository

- JobOpeningRepository
- JobApplicationRepository

## Class diagram

![](../CD/CD.svg)

## Observations

- Transactional context are used instead of events for increase service processing speed.