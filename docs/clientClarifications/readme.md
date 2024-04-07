### 2024-02-29

**Q1:** Are there MVPs for each sprint?  
**A1:** No. There are no MVPs for each sprint. There can be minimum functionality for each sprint but it depends on the
team structure and composition. Professors from each UC may define minimum requirements in this context.

### 2024-03-09

**Q2:** Are interviews conducted in person? If so, who is responsible for recording these answers in the system?  
**A2:** The means used for interviews are outside the scope of the system. They can be in-person, remote (e.g., phone or
other means). Regardless of the means, the Customer Manager is responsible for recording the answers in the system by
submitting (uploading) the text file with the candidate's responses.

**Q3:** Who is responsible for analyzing applications?  
**A3:** It will be the Customer Manager. They analyze the applications and decide the ranking of the candidates.

### 2024-03-14

**Q4:** Regarding the continuous integration server, should the workflow be executed with each push or once a day, at
night?  
**A4:** Whenever there is a push to the "main". The CI process for each push cannot exceed 2 minutes. The process should
be able to "compile" the system, run tests, and publish results without "errors," meaning it should not fail due to "
compilation" errors. In case of failures, the "responsible" for the failure (commit/push author) must justify the
failure (for example, by documenting it in their repository area).

**Q5:** What is the distinction between Company and Entity?  
**A5:** When the term "entity" is used, it refers to the possibility of having Jobs4u clients who may not be companies;
they may be other types of organizations.

**Q6:** Is there only one "representative" accessing the account (i.e., Customer App) for each Customer?  
**A6:** Yes, it seems sufficient.

**Q7:** In the context where the Customer Manager registers a job offer, how are the requirements for that job offer
selected/defined?  
**A7:** The Customer Manager registers the job opening (US 1002) and then (usually) selects which requirements
specification is suitable for that job opening. The requirements specification will be one of those "created" by the
language engineer and registered in the system.

**Q8:** The email bot is referred to as "out of scope." Is this regarding the system or the business model?  
**A8:** From the perspective of the application reception process, it is important to understand how applications are
received and processed. That said, the automated process described as "email bot" is outside the scope of the solution
to be developed, as illustrated in Figure 4.1.

**Q9:** Regarding G005, are the mentioned scripts only for building and testing?  
**A9:** I would say that at this stage (sprint A), the scripts probably only refer to building applications, running
tests, and executing applications. However, the idea is to maintain a set of scripts that allow performing the most
common operations in a simplified way outside the IDE at any given moment. This becomes more important later when more
complex "deployments" need to be prepared.

**Q10:** Is the Admin responsible for managing only Customer managers or others, such as Operators? And what is the
significance of this responsibility?  
**A10:** The idea is that the Admin will manage these users (and possibly also Operators). In practice, the user
stories (US) referring to these functionalities can be replaced by a "bootstrap" process that initializes the database
to support these users/roles (as mentioned in the US text).

**Q11:** In the statement, information to collect for Customers is not explicitly mentioned. What information is
necessary? And what about company employees?  
**A11:** Indeed, this is not explicitly stated. However, the company name and its address are mentioned within the scope
of a job opening. Regarding users (company representatives accessing the Customer App), they would likely provide
similar information to that of a Candidate. As for company employees, it is important to ensure that their email is used
to identify any system user. I believe it is important for each user to have a full name as well as a short username (
which should be unique). Update on 2024-03-21: The Product Owner reconsidered and decided that the short username is
dispensable since only the email and password should be used for user authentication.

**Q12:** What is the distinction between requirements specification and interviews?  
**A12:** The "style" of questions and answers is similar, but in requirements, the objective is to evaluate the
candidate and see if they meet the minimum requirements or not, so the result will be yes or no. In interviews, the idea
is to classify/rate each answer in order to have different scores for the candidates in the end and thus help in ranking
them.

**Q13:** Can a customer manager manage multiple clients?  
**A13:** Yes.

**Q14:** Who informs the Customer manager of the type of interview/questions?  
**A14:** This can be obtained by the Customer manager in dialogue with the Customer. After that, with the help of the
Language engineer, support for the interview is prepared.

### 2024-03-16

**Q15:** Is it the Operator who registers an application, or does the system do it automatically? And how does the "
plugin" for application verification integrate into this process?  
**A15:** In US 2002, the Operator registers the application. For this, the Operator initiates the process, but the
system must import the data resulting from the Application File Bot automatically (see References of US 2002). The
mentioned plugin enters this process through US 2003, where the Operator generates a template file with the data to be
entered to validate an application. In US 2004, after filling in the specific application data (based on the previous
template file), the Operator submits that file in the system, which will be used for the system to evaluate/verify the
application. If the criteria are not met, the application is rejected.

**Q16:** Regarding the recruitment process phases mentioned in section 2.2.1, must the previous phase be closed to move
on to the next, or can we proceed without having the previous one closed?  
**A16:** The short answer is that the phases should be sequential and not overlapped. When one phase is closed, the next
one opens. US 1007 defines the phases. US 1010 defines the opening and closing of process phases. The Customer Manager's
decision to close a phase should assume that the process automatically advances to the next phase (regardless of the
dates defined for the phases).

**Q17:** In section 2.2.1, is it in the Analysis phase that interviews are evaluated, and is that result what defines
the ranking of candidates? Also, what is the CV used for in this phase? Since interviews are not mandatory, what happens
when they do not occur?  
**A17:** The scoring of interviews is carried out/calculated in the interview phase. The CV and other data (such as the
result of interviews) are used by the Customer Manager in the analysis phase to rank the candidates. However, the
ranking is the responsibility of the Customer Manager (for example, it does not have to follow the interview score
order). US 1013 corresponds to the manual ranking of candidates performed by the Customer Manager. The absence of
interviews does not affect the ranking of candidates as it does not explicitly depend on interviews.

**Q18:** In US 1011, how does the Customer Manager select the model to use for interviews?  
**A18:** It is assumed that when the models are registered in the system (the so-called "plugins"), they are identified
with a name or description. For example, "Interview Model for Supermarket Checkout Operator" or "Interview Model for
Junior Backend Java Programmer." In US 1011, the Customer Manager is supposed to select a model from a possible list of
models.

### 2024-03-21

**Q19:** When creating a user in the system, is the name defined by the user, or is it the person's name (first and
last), and is the password defined by the user or generated by the system?  
**A19:** In the scope of US 2000a, the Operator creates system users for candidates who are not yet in the system. This
is done based on the data received in the application (including email and name). The email serves to identify the
person. In this context, a password is necessary for this new user. Since this information is not transmitted by the
candidate, the most "advisable" solution would be for the system to generate a password for this user. Since how the
user/candidate receives this information (the form of authentication in the app) is out of scope, there is no US
referring to it. US 1000 and 1001 also refer to user creation. Here, one could potentially manually input passwords, but
it could be done through the same mechanism of automatic password generation described earlier. Regarding the name,
refer again to Q11.

**Q20:** Can a person have multiple roles in the system?  
**A20:** It will be very difficult to control that a person cannot have more than one form of access to the system (for
example, a person who is a Customer Manager could also potentially be a candidate for a job opening). Regarding "
internal" roles, I would say that we should consider a hierarchy of accesses. The Admin can do "everything" the others
do. Next is the Customer Manager, and lastly the Operator.

**Q21:** Regarding Companies, and related to Q11, what did the mentioned address mean in the response?  
**A21:** I was referring to the company's postal address (not the email address).

**Q22:** Regarding the Job Opening (section 2.2.2), the job reference states that it should be generated by the system
from a customer code. What is this customer code, and are there any rules for its creation?  
**A22:** I would say that any customer must have an identifying (unique) code that could be a kind of abbreviation of
their name. With a limited number of characters. For example, for the client Instituto Superior de Engenharia do Porto,
the customer code could be ISEP, and there could not be another customer with this customer code. A reasonable limit
would perhaps be 8 to 10 characters. Let's define it as 10. This code is manually entered when creating the customer in
the system.

**Q23:** Is the state change related to the candidate or the individual application, and how does it relate to the
enable/disable of users?  
**A23:** The enable/disable of users is only to control access to the system. The state, in the application process, is
the state of a candidate's application to a job opening, not directly related to enabling/disabling users.

**Q24:** To identify an application, is the candidate's ID and the job opening's ID used?  
**A24:** It's not quite like that. Applications will enter the system through files generated by the Application Email
Bot. These files are identified by the Job Reference followed by a "number" that identifies the application to that job
reference. It will typically be a sequential number. The content of these files will contain the candidate's data. Note
that the candidate may not even exist yet (i.e., may not have a record in the system).

**Q25:** In the job opening, is everything mandatory, or are there optional fields?  
**A25:** The fields mentioned in section 2.2.2 are mandatory. The requirements will be dynamic as they depend on the
requirements specification selected for that job opening (which is based on a language).

### 2024-03-23

**Q26:** At what point is the recruitment process initiated? Are there more than one recruitment phase, and how are the
phases distinguished, by date?  
**A26:** Refer to the answer to Q16.

**Q27:** Does the score from the selection test model represent the candidate's ranking in the selection process?  
**A27:** Refer to the answer to Q17 (indirectly answered).

**Q28:** Is it intended for each Customer to be identified in the system as a user?  
**A28:** Refer to the answer to Q6 (indirectly answered).

**Q29:** From the perspective of the app file bot, should it represent a service in the system?  
**A29:** I would say yes, as it is a process necessary in the system to transform received data into a format recognized
by the recruitment process.

**Q30:** In US2000b, what is the "enable/disable" of the candidate?  
**A30:** (some reference to Q23). It refers to disabling the candidate's access to the system (i.e., Candidate App).

**Q31:** About the job specification, should the client send the requirements, or is it the responsibility of the
customer manager? What is the concept of a job specification?  
**A31:** (some reference to Q25). Typically, it will be the customer who informs the customer manager of the minimum
requirements for a job offer. The Customer manager checks if there is already a suitable requirements specification. If
not, with the help of the Language Engineer, a new one is created.

**Q32:** Do candidates also have associated states? As the process progresses, is the candidate's state also updated?  
**A32:** The state is of the application. Progress in the process may not lead to "progress" in an application because,
for example, at the end of the screening, the application may be rejected, and in that case, that application ends
there. Other applications follow the process.

**Q33:** Does the candidate have an identifying code, or is it the email that identifies them?  
**A33:** The candidate's identification is by email. There will be no need for a code.

**Q34:** In US3002, when it lists job openings, what does "position" mean?  
**A34:** In that US, when referring to "position," it has the same meaning as "title or function" in section 2.2.2.

**Q35:** Does a Customer have to provide the address and company name, or is it enough for this information to be in the
job opening?  
**A35:** We should register the name and address of the customer. For each job opening, the address can be specific (and
different from the customer's address).

**Q36:** In US1021, what is "all data of an application"? What is a job application?  
**A36:** A job application is an application (from a candidate) to a job opening. Regarding "all data of an
application," it refers to all the data of an application, including the files submitted by the candidates, as well as
data collected or generated during the process (such as interviews and requirements processing).

### 2024-04-04

**Q37** No job opening (secção 2.2.2), no campo company, deve ser o customer name ou o customer code, uma vez que o
customer code é único e introduzido manualmente?
**A37** A informação relativa ao job opening que aparece no final da página 5 deve ser vista como algo a ser usado na
divulgação de uma oferta de emprego. Nesse contexto, para a Company faz mais sentido divulgar o nome da company e não o
seu código. Dito isto, em termos de armazenamento numa base de dados poderá ficar o código.

**Q38** Cada questão de um interview model aceita um x tipos de respostas(ex escolha múltipla) ou é a interview model
que aceita um x tipos de respostas em todas as suas questões? Assumimos que uma job opening só segue um interview model?
**A38** Sim, cada pergunta/resposta aceita um tipo de pergunta/resposta (um dos tipos que aparece no inicio da página
8). Na US1011, o Customer manager seleciona o interview model a usar nas entrevistas para um job opening. Ou seja,
existirá apenas um interview model a usar nas entrevistas desse job opening.

**Q39** João – O recruitment process é como está definido ou pode haver alterações no futuro?
**A39** O processo é o que está descrito na secção 2.2.1. Neste momento a única fase opcional é a das entrevistas.

**Q40** Bernardo – Uma entrevista pode ter apenas uma questão? US1014, time and date, quer dizer data de inicio e não
data final? Podem haver entrevistas em paralelo?
**A40** Quanto ao número de perguntas numa entrevista, não está definido nenhum limite inferior ou superior. Ou seja,
pode haver uma entrevista com apenas 1 pergunta (não fará sentido não ter perguntas). A US1014 refere-se à marcação da
data de uma entrevista com um candidato. Algo como indicar o dia e a hora (ex: 23 de abril pelas 14:00). Em relação à
marcação de entrevistas “sobrepostas” (com a mesma data de inicio), neste momento, seria algo a permitir (pode, por
exemplo, o customer manager delegar noutra pessoa a condução da entrevista). Isso não invalida que devam validar se as
entrevistas ocorrem dentro da fase das entrevistas.

**Q41** Como é que o Language Engineer faz o interview model e os job requirements? É texto? Ou ele seleciona perguntas
para a interview e requirements para a job opening? E isso é quando se está a criar uma entrevista ou uma job opening ou
para-se a meio para fazer isso e depois continua se?
**A41** O language enginner com informação passada pelo customer manager (que obteve do customer) vai desenvolver em
java um jar correspondente ao modulo/plugin. Para esse desenvolvimento terá de utilizar técnicas de desenvolvimento de
gramáticas/linguagens como o antlr. Esse código ficará num jar que depois o language engineer “instala/regista” na
aplicação (US1008, por exemplo, associando um nome ao jar num ficheiro de configuração – “5 anos experiencia java”,
“req-model-5-years-java.jar”). A aplicação com essa informação carrega dinamicamente esse jar. Na gramátca usada no jar
é que vão estar espelhadas a estrutura das perguntas a usar nesse modelo e sua avaliação. Estas atividades têm de ser
feitas antes de se poder fazer a US1008. Esse trabalho é feito “fora” dos sistema, apenas se registando o modelo (quando
está pronto) na US1008. A US 1009 e US1011 permitem selecionar modelos a usar (dos que foram devidamente registados no
sistema).

**Q42** Bernado – US1006, Qual a informação do nome do candidato deve aparecer (nome completo, primeiro e ultimo nome ,
etc)?
**A42** À partida diria que seria o nome, tal como foi recebido na application que fez (página 6, “name of the
candidate”)

### 2024-04-06

**Q43** Para os candidato e para os utilizadores do sistema que informações são necessárias?
**A43** Alguma informação anterior é referida na Q11. Para além disso a secção 2.2.3 refere que relativamente aos
candidatos temos a seguinte informação: email of the candidate, name of teh candidate, phone number of the candidate.

**Q44** Relativamente à secção 2.2.3 e ao facto de o application email bot estar fora do scope mas produzir a informação
descrita nessa secção, será disponibilizado exemplos dessa informação?
**A44** Sim. Será disponibilizado um exemplo da informação produzida pelo application email bot.

**Q45** Relativamente aos estados possíveis de uma candidatura, quais são os estados possíveis?
**A45** O estado deve refletir em que estado do processo se encontra e o possível resultado final. Do ponto do vista do
cliente, deve ser algo que faça sentido para ele. Ou seja, não sei se faz sentido o candidato saber detalhes que podem
não fazer sentido para ele, pois este pode não conhecer todos os detalhes internos da gestão de um processo de
candidatura.

**Q46** US1007, o identificar do processo de recrutamento pode ser um numero automático ou seja mais especifico?
**A46** O job opening tem um identificar. O processo de recrutamento de um job opening é um “tributo” desse job opening.
À partida não vejo necessidade de ter um identificador “especial” para o processo de recrutamento (i.e., fases do
processo de recrutamento desse job opening).

**Q47** US1008, relativamente aos módulos das entrevistas e dos requisitos, os seus identificadores podem ser
automáticos ou específicos(i.e., manuais)?
**A47** A Q41 refere a mesma US. Lá refere-se que cada modulo será registado no sistema através de 2 dados, por exemplo,
associando um nome ao jar num ficheiro de configuração – “5 anos experiencia java”, “req-model-5-years-java.jar”. Ou
seja, assume- se que cada modulo terá um nome/designação (que suponho que deverá ser única) e a este nome ficará
associado o nome do ficheiro jar (provavelmente um path completo) que implementa esse módulo. Ou seja, esse
nome/designação pode ser considerado como um identificador especifico/manual.

**Q48** US1016 e US1020, relativamente ao envio das notificações por email, é necessário guardar que esse envio foi
feito?
**A48** No documento nada de explicito é dito sobre este assunto. No entanto, do ponto de vista de gestão do processo da
jobs4u parece-me adequado que essa informação fique registada.