# Client Clarifications

This document provides clarifications on various issues related to the system under development. Below are the questions asked by Product Owners along with their respective answers:

## 2024-02-29

**Q1 - Are there MVPs for each sprint?**  
*A1* Short answer: No. There are no MVPs for each sprint. There can be minimum functionality for each sprint but it depends on the team structure and composition. Professors from each UC may define minimum requirements in this context.

## 2024-03-09

**Q2 - Are interviews conducted in person? If so, who is responsible for recording these responses in the system?**  
*A2* The means used for interviews are outside the scope of the system. They can be in-person, remote (e.g., phone or other means). Regardless of the method, the Customer Manager is responsible for recording the responses in the system by submitting (uploading) the text file with the candidate's responses.

**Q3 - Who is responsible for analyzing the applications?**  
*A3* It will be the Customer Manager. They analyze the applications and decide on the ranking of the candidates.

## 2024-03-14

**Q4 - Regarding the continuous integration server, will the workflow need to be executed with every push or once a day, at night?**  
*A4* Quick answer: whenever there is a push to the “main”. The process executed by the CI with each push cannot exceed 2 minutes. The process should be able to “compile” the system, run tests, and publish results without “errors”, meaning it should not fail due to “compilation” errors. In case of failures, the “responsible” for the failure (commit/push author) must justify the failure (for example, by justifying in their repository documentation area).

**Q5 – What is the distinction between Company and Entity?**  
*A5* When the reference to entity appears in the statement, it means we can have Jobs4u clients who may not be companies; they can be other types of organizations.

**Q6 – Is there only one “representative” per Customer who accesses the account (i.e., Customer App)?**  
*A6* Yes, that seems sufficient.

**Q7 – In the context where the Customer Manager registers a job offer, how are the requirements for that job offer selected/defined?**  
*A7* The Customer manager registers the job opening (US 1002) and then (usually) selects which requirements specification is suitable for that job opening. The requirements specification will be one of those “created” by the language engineer and registered in the system.

**Q8 – The email bot is referred to as “out of scope”. Is this regarding the system or the business model?**  
*A8* From the perspective of the application process, it is important to understand how applications are received and processed. That being said, the automatic process described as the “email bot” is outside the scope of the solution to be developed, as illustrated in figure 4.1.

**Q9 – Regarding G005, are the scripts mentioned only for building and testing?**  
*A9* I would say that at this stage (sprint A), possibly the scripts refer only to building the applications, running tests, and executing the applications. However, the idea is to be able to maintain a set of scripts that allow the most common operations to be performed easily and outside of the IDE at any given moment. This becomes more important later when more complex “deployments” need to be prepared, for example.

**Q10 – Is the Admin responsible for managing only Customer managers or others, such as Operators? And what is the significance of this responsibility?**  
*A10* The idea is that the Admin will manage these users (and potentially also Operators). In practice, the user stories related to these functionalities can be “replaced” by a “bootstrap” process that initializes the database to support these users/roles (as mentioned in the user stories text).

**Q11 – The statement does not explicitly state the information to be collected for Customers. What information is necessary? And what about company employees?**  
*A11* Indeed, this is not explicitly stated. However, the company name and address are mentioned within the scope of a job opening. As for the users (company representatives accessing the Customer App), I would say they will have similar data to the Candidate. As for company employees, it is important to ensure that the email is used to identify any system user. I think it will be important for each user to have the full name as well as a short username (which should be unique).

**Q12 – What is the distinction between requirements specification and interviews?**  
*A12* The “style” of questions and answers is similar, but in requirements, the goal is to evaluate the candidate and see if they meet the minimum requirements or not, so the result will be yes or no. In interviews, the idea is to classify/rate each answer in order to have different scores for the candidates at the end and thus help with their ranking.

**Q13 – Can a customer manager handle multiple clients?**  
*A13* Yes.

**Q14 – Who informs the Customer manager of the type of interview/questions?**  
*A14* This can be obtained by the Customer manager in dialogue with the Customer. After that, with the help of the Language engineer, support for the interview is prepared.

**Q15 – É o Operador que regista uma candidatura ou é o sistema que o faz automaticamente? E como integra o “plugin” de verificação da candidatura neste processo?**
*A15* Na US 2002 o Operator regista a candidatura. Para isso, é o Operator que inicia o processo mas o sistema deve importar os dados resultantes do Application File Bot de forma “automática” (Ver References da US 2002). O plugin referido entre neste processo através da US 2003, em que o Operador gera um ficheiro template com os dados a introduzir para validar uma candidatura. Na US 2004, o Operador, após preencher os dados específicos da candidatura (com base no ficheiro template anterior) submete no sistema esse ficheiro que vai ser usado para o sistema avaliar/verificar a candidatura. Se os critérios não forem atingidos a candidatura é recusada.

**Q16 - Relativamente à secção 2.2.1 e às fases do processo de recrutamento, para passarmos para a fase seguinte a anterior tem de fechar ou podemos avançar sem ter a anterior fechada?**
*A16* A resposta curta é que as fases devem ser sequencias e não sobreposta. Quando fecha uma fase abre a próxima. A US 1007 prevê a definição das fases. A US 1010 prevê a abertura e fecho de fases do processo. A decisão do Customer Manager de fechar um fase deve assumir que o processo avança para a próxima fase automaticamente (independentemente das datas definidas para as fases).

**Q17 – Relativamente à secção 2.2.1, é na fase de Analysis que as entrevistas são avaliadas e é esse resultado que define o ranking dos candidatos? Além disso, para que serve o CV nesta fase? Visto que as entrevistas não são obrigatórias, o que acontece quando estas não se realizam?**
*A17* A pontuação das entrevistas é efetuada/calculada na fase das entrevistas. O CV e outros dados (como o resultado das entrevistas) é usado pelo Customer manager na fase de analise para ordenar os candidatos. Mas a ordenação é da responsabilidade do Customer Manager (por exemplo, não tem de seguir a ordem da pontuação nas entrevistas). A US 1013 corresponde à ordenação manual dos candidatos feita pelo Customer Manager. O facto de não haver entrevistas não tem implicações na ordenação dos candidatos pois esta não depende explicitamente das entrevistas. 

**Q18 Beatriz – Na US 1011 como é que o Customer Manager seleciona o modelo a usar para as entrevistas?**
*A18* Admite-se que os modelos quando são registados no sistema (os tais “plugins”) ficam identificados com um nome ou descrição. Por exemplo “Modelo de Entrevista para Operador de Caixa de Supermercado” ou “Modelo de Entrevista para Programador Junior Backend Java”. Na US 1011 é suposto o Customer manager selecionar um modelo de uma possível lista de modelos.