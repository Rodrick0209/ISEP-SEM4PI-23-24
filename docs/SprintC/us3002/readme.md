# US 3002 - As Customer, I want to list all my job openings

## 1. Context

This Us is related to RCOMP, the customer should be able to see his job openings, and this information should be accessed by a server.

## 2. Requirements

**3002** As Customer, I want to list all my job openings, including job reference, position, active since, number of applications.

**Dependencies/References:**<a id="dependencias"></a>

This user story have some dependencies with the following user stories:


| US                                       | Reason                                                                            |
|------------------------------------------|-----------------------------------------------------------------------------------|
| [G007](../../SprintB/g007/readme.md)     | Whe need the authentication to ensure is a customer that is logged                |
| [US1002](../../SprintB/us1002/readme.md) | This us is responsible for creating job Openings, that is required to us 3002     |
| [US2002](../../SprintB/us2002/readme.md) | This us is responsible for creating job applications, that is required to us 3002 |

## 3. Analysis

### What is asked?
The task requires implementing a feature for customers to list all their job openings, displaying job reference, position, active since date, and the number of applicants. This feature must comply with specific technical requirements, including a client-server architecture where the client accesses data through a server application, without direct database access. Additionally, the solution must be deployed on multiple network nodes, with separate nodes for the database server and Follow Up Server, ideally in the cloud, ensuring background execution of email notifications.


### Domain model

This user story doesn't have any impact on the domain model.



### Client Clarifications
- Position in this Us, is the same as title or function in the job opening
- In the context of this US, “active since” means the date from the start of the process, the “application” phase (since that date, candidates can apply). This functionality should include all the “active” job openings.


### How is supposed to work?

The customer should be able to list all his job openings, including job reference, position, active since, number of applications. This information should be accessed by a server.
To achieve this, the customer must follow the steps below:
1. Access the system as a customer.
2. Access the job openings Menu.
3. Select the option to list all job openings.
4. The system should display a list of all job openings, including job reference, position, active since, and the number of applications.

### SSD
![s](SSD//ssd.svg)

### Dependencies to other user stories
- [Dependencies table](#dependencias)

### Impact in the business

These implementations will allow the customer to have a better overview of the job openings, making it easier to manage them. It also allow the system to get the information by a server, making it more secure. 



## 4. Design


### 4.1. Realization


### 4.2. Class Diagram

### 4.3. Applied Patterns
### 4.4. Tests

#### 4.4.1. Unit Tests

##### Rank Class


#### 4.4.2. Integration Tests



## 5. Implementation






## 6. Integration/Demonstration

### Integration


### Demonstration



## 7. Observations


