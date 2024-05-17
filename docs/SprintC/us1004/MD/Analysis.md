# Analysis

- **The customer manager, after registering the job opening, is able to edit its information.**

## Client meeting

**Question:** 

- No seguimento da US 1004 para permitir editar um job opening, estamos a assumir que é permitido alterar: Nº de vagas; Morada; Contract Type('FULL_TIME', 'PART_TIME'); Mode ('ON_SITE','REMOTE'); Description; Funcao. Estamos na linha de raciocício correta, ou é necessário alterar a lista para incluir outra informação adicional ou suprimir alguma desta lista?

**Answer:**

- Do meu ponto de vista deve ser possível alterar “tudo” exceto o próprio job reference.

**Question:**

- Em quais ou até que fases de recrutamento de um Job Opening em que pode-se editar as informações dela?

**Answer:**

- As alterações devem ser compatíveis com o “momento” em que estamos nessa job opening. Por exemplo, não faz sentido alterar o contrat type se já estamos a receber candidaturas. Essas candidaturas foram feitas segundo uma descrição da oferta de emprego e não faz sentido estar a alterar depois de as pessoas se candidatarem. Mas, por exemplo, deve ser possível alterar o job requirements specification (refere-se a outra US) enquanto as pessoas se candidatam, pois é um aspeto técnico, que não é do conhecimento público.

**Question:**

- A cada edição feita de alguma informação numa Job Opening, é necessário registar a data e a hora da edição, tal como acontece no momento de registar a Job Opening?

**Answer:**

- É comum haver um registo do utilizador que criou ou fez a última atualização de um “registo” no sistema.

## Business Rules

- The customer manager must select only one job opening to edit at a time.
- The customer manager can only edit information about a job opening that was previously registered in the process of registering the job opening (working mode, number of vacancies, address, description, function, type of contract or client), with the exception of the job reference.
- The customer manager can edit one job opening information at a time.
- The customer manager cannot edit a job opening when it is in the active state (after entering the Application phase).

## System functionality

### Edit working mode of a job opening

![](../SSD/SSD-Edit-Working-Mode.svg)

### Edit number of vacancies of a job opening

![](../SSD/SSD-Edit-Number-Vacancies.svg)

### Edit address of a job opening

![](../SSD/SSD-Edit-Address.svg)

### Edit description of a job opening

![](../SSD/SSD-Edit-Description.svg)

### Edit function of a job opening

![](../SSD/SSD-Edit-Function.svg)

### Edit contract type of a job opening

![](../SSD/SSD-Edit-Contract-Type.svg)