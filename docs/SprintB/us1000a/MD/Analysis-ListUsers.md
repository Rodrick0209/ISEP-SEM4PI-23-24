# Analysis

## Business Rules

- This US is directly related to the users of the backoffice.
- To make this change, the user must be of the admin type.
- The listing of users only shows the users of the backoffice.
- The listing of users must show the user's name, email, and status (enable or disable).


## Unit Tests

- EnsureGetListUsersWorks - The listing of users return users of the backoffice. 
- EnsureGetListUsersWorksForBackOfficeUsers - The listing of users only shows the users of the backoffice.
- EnsureGetListEmptyWorks - The listing of users must show a message when there are no users.
