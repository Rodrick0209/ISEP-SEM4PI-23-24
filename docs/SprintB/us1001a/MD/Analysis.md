# Analysis

## Client Meeting
- Each client/customer has only um representative that accesses the account.
- Each client should have its name, postal address and code.
- Client code shoud me introduced manually whenever the creation in the system.
- Client code should be unique.
- The client users(client representatives that acces the Customer app) are name, email and phone number.
- Users authentication will include only its password and email.
- Client advised that the password should be automatically generated and sent to the users, but this last part is out of scope for this project.
- The Password should be automatically generated and sent to the users, but this last part is out of scope for this project.


## Business Rules
- Each client must have a unique representative who has access to the account.
- User authentication must be done using the user's email and password.
- The password for the user should be automatically generated.
- The client code should have a maximum of 10 characters.

## Unit Tests
- Test that a client cannot be created without all of its attributes(name,postal address,code).
- Test that all client attributes should be valid.
- Test that a client cannot be created with a code that is already in use.
- Test that a client cannot be created without a user being attributed to its representative.
- Test that a client's representative cannot be created without a name, email, or phone number.
- Test that a client's representative cannot be created with an email that is already in use.

