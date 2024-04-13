# Analysis

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


## Unit Tests

- EnsureNewlyUserIsEnable - When a user is initially created, it is in the enable state
- EnsureUserIsDisable - Ensure if it's possible to disable a user
- EnsureUserIsEnable - Ensure if it's possible to enable a user