# UC 1000b

# 1. Requirements
**1000b** As Administrator, I want to be disable/enable users of the backoffice
- Create a new services with all the attributes.
The interpretation made of this requirement was to create a service with all the necessary attributes for its creation.
  


# 2. Analysis
## Client Meeting

- The enable/disable of users is only to control access to the system.

## Business Rules

- When a user is initially created, it is in the enable state.
- This US is directly related to the users of the backoffice.
- To make this change, the user must be of the admin type.
- A user now has an enable or disable state
- This state will be important in the future for the possibility of accessing the system
- It's only possible to disable a user if the user is enabled
- It's only possible to enable a user if the user is disabled

# 3. Design
- To implement this functionality, the team used the Controller and Repository pattern.
- Use the standard base structure of the layered application


### Domain Classes

- SystemUser and its associated classes

### Controller

- EnableUserController - For enabling the user
- DisableUserController - For disabling the user

### Service

- UserManagementService

### Repository

- UserRepository



## 3.1. Class Diagram

## Enable User

![Enable User](CD/EnableUserCD.png)

## Disable User

![Disable User](CD/DisableUserCD.png)


# 3.2. Sequence Diagram

## Enable User

![Enable User](SD/SDEnableUser.jpg)

## Disable User

![Disable User](SD/SDDisableUser.jpg)


# 4. Test Plan

### Case #1: Enable User (existing disable users)

1. Log in as admin
2. Choose the Option User > Enable User
3. Display all the users in disable state
4. Choose a user to update
5. Confirm the update made through List users (User > List Users)


### Case #2: Enable User (does not exist disable users)

1. Log in as admin
2. Choose the Option User > Enable User
3. Display a message "There are no users to enable"


### Case #3: Disable User (existing enable users)

1. Log in as admin
2. Choose the Option User > Disable User
3. Display all the users in enable state
4. Choose a user to update
5. Confirm the update made through List users (User > List Users)


### Case #4: Disable User (does not exist enable users)

1. Log in as admin
2. Choose the Option User > Disable User
3. Display a message "There are no users to disable"
   