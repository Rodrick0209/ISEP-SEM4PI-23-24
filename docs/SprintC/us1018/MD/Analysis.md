# Analysis

- **The customer manager is able to execute the process of evaluation of interviews for a Job Opening.**

## Client meeting

**Question (captured from US 1015):**

-  Deve ser executado o processo para todos os candidatos ou apenas para alguns (segundo algum critério)?

**Answer:**

-  Os ficheiros com as respostas aos requisitos vão entrando no sistema gradualmente. Talvez seja mais “simples” que o processo execute (ou seja, faça a verificação dos requisitos) para os candidatos para os quais já foi submetido o ficheiro de requisitos. Nalgum momento o processo irá executar com todos os candidatos já com os ficheiros de requisitos submetidos.

**Question:**

- No caso de upload de um ficheiro, se a pergunta que requer um número como resposta for preenchida com um formato inválido, por exemplo, uma letra, devemos considerar isso como um formato inválido na US 1017 (e pedir para o user voltar a dar upload a um ficheiro válido) ou devemos, na US1018, considerar que está incorreta e atribuir 0 pontos automaticamente para essa resposta inválida? Isto é, na US 1017, devemos apenas verificar o formato do ficheiro ou devemos verificar também se as respostas são preenchidas com o tipo de dados correto?

**Answer:**

- O caso mencionado deve ser considerado um erro de validação do ficheiro (ou seja, o ficheiro submetido não corresponde à gramática definida).

## Business rules

- The job opening must be in interview phase.
- The process of execution of evaluation of interviews is only made in job applications with interview answers but without interview points.
- The evaluation of each interview must result in a value in a number with a range of 0-100 and is automatically settled on each job application.

## System functionality

![](../SSD/SSD.svg)
