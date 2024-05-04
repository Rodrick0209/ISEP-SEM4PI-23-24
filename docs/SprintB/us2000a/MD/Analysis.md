# Analysis

## Client Meeting
-  No âmbito da US 2000a o Operator cria utilizadores do sistema para candidatos que ainda não estejam no sistema. Tem de fazer isso com base nos dados recebidos na candidatura (que incluem email e nome). O email servirá para identificar a pessoa. Neste contexto é necessário ter uma password para esse novo utilizador. Uma vez que essa informação não é transmitida pelo candidato, suponho que a solução mais “aconselhada” será o sistema gerar uma password para esse utilizador. Como o utilizador/candidato irá receber essa informação (a forma de autenticação na app) está out of scope, no sentido em que não existe nenhuma US que remete para isso.
-  A US2000a refere-se a uma funcionalidade do Operador, manualmente, registar candidatos.

## Business Rules
-Each candidate is identified by a unique email.
-Each candidate has a name, email, phone number.
-Each candidate has a password, which is automatically generated (Even though it is not in the scope of this project any way to inform the candidate of this password).

## Unit Tests
- Test that a candidate cannot be created without all of its attributes(name,email,phone number).
- Test that all candidate attributes should be valid.
- Test that a candidate cannot be created with an email that is already in use.
- Test that a password is automatically generated for the candidate.

