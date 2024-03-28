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
*A11* De facto isso não está explicito. No entanto, são referidos no nome da empresa e o seu endereço no âmbito de um job opening. Quanto aos utilizadores (representante da empresa que acede à Customer App) eu diria que serão dados similares ao do Candidate. Quando aos funcionários da empresa, eu diria que é importante garantir que é usado o email para identificar qualquer utilizador do sistema. Penso que será importante para cada utilizador termos o nome completo assim como um short user name (que deverá ser único). Actualização em 2024-03-21: O Product Owner reconsiderou e decidiu que o short user name é dispensável uma vez que para autenticação dos utilizadores se deve usar apenas o email e a password.

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

**Q18 – Na US 1011 como é que o Customer Manager seleciona o modelo a usar para as entrevistas?**
*A18* Admite-se que os modelos quando são registados no sistema (os tais “plugins”) ficam identificados com um nome ou descrição. Por exemplo “Modelo de Entrevista para Operador de Caixa de Supermercado” ou “Modelo de Entrevista para Programador Junior Backend Java”. Na US 1011 é suposto o Customer manager selecionar um modelo de uma possível lista de modelos.

## 2024-03-21

**Q19 – Na criação de um utilizador no sistema o nome é definido pelo utilizador ou é o nome da pessoa (primeiro e último) e se a password é definida pelo utilizador ou gerada pelo sistema?**
*A19* No âmbito da US 2000a o Operator cria utilizadores do sistema para candidatos que ainda não estejam no sistema. Tem de fazer isso com base nos dados recebidos na candidatura (que incluem email e nome). O email servirá para identificar a pessoa. Neste contexto é necessário ter uma password para esse novo utilizador. Uma vez que essa informação não é transmitida pelo candidato, suponho que a solução mais “aconselhada” será o sistema gerar uma password para esse utilizador. Como o utilizador/candidato irá receber essa informação (a forma de autenticação na app) está out of scope, no sentido em que não existe nenhuma US que remete para isso. As US 1000 e 1001 também remetem para criação de utilizadores. Aqui, eventualmente poderia-se pensar em introduzir manualmente as passwords, mas pode ser pelo mesmo mecanismo de definição automática de password, descrito anteriormente. Relativamente ao nome ver novamente a Q11.

**Q20 – Uma pessoa poderá ter vários papeis no sistema?**
*A20* Será muito difícil controlar que uma pessoa não consegue ter mais do que uma forma de acesso ao sistema (por exemplo, uma pessoa que é Customer Manager poderá ser, no limite, também uma candidato a uma oferta de emprego). Relativamente aos papéis “internos” eu diria que devemos considerar uma hierarquia de acessos. O Admin pode fazer “tudo” o que os outros fazem. Segue-se o Customer Manager e por último o Operator.

**Q21 – Relativamente às Empresas, e relacionado com a Q11, o que é que significava o endereço mencionado na resposta?**
*A21* Estava a referir-me ao endereço postal da empresa (não ao endereço email).

**Q22 – Relativamente ao Job Opening (secção 2.2.2), o job reference refere que deve ser gerado pelo sistema a partir de um customer code. O que é este customer code e se existe alguma regra para a sua criação?**
*A22* Eu dira que qualquer customer terá de ter um código identificativo (único) que poderá ser uma espécie de abreviatura do seu nome. Com um número limitado de caracteres. Por exemplo, para o cliente Instituto Superior de Engenharia do Porto, o customer code poderi ser ISEP e não poderia haver mais nenhum customer com este customer code. Um limite razoável seria talvez 8 a 10 carateres. Podemos definir 10. Este código é introduzido manualmente na criação do customer no sistema.

**Q23 – A mudança de estado é referente ao candidato ou à candidatura individual e como se relaciona com o enable/disable dos utilizadores?**
*A23* O enable/disable dos users é apenas para controlar os acessos ao sistema. O estado, no processo de candidatura, é o estado da candidatura de um candidato a um job opening, não está diretamente relacionado com o enable/disable dos users.

**Q24 – Para identificar uma candidatura usa-se o id do candidato e o id do job opening?**
*A24* Não é bem assim. As candidaturas vão entrar no sistema através dos ficheiros gerados pelo Application Email Bot. Esses ficheiros vêm identificados pelo Job Reference seguido de um “números” que identifica a candidatura a esse job reference. Será tipicamente um número sequencial. No conteúdo desses ficheiros vai aparecer os dados do candidato. Repare-se que pode até o candidato ainda não existir (não ter registo no sistema).

**Q25 – No job opening é tudo de preenchimento obrigatório ou existem opcionais?**
*A25* Os campos referidos na secção 2.2.2 são de preenchimento obrigatório. Os requirements vão ser dinâmicos uma vez que dependem do requirements specification selecionado para aquele job opening (que se baseia numa linguagem).

## 2024-03-23

**Q26 – Em que momento é que o processo de recrutamento é iniciado? Existe mais que uma fase do recrutamento, como é que distinguem as fases, é pela data?**
*A26* Remete-se a resposta para a Q16.

**Q27 – A nota do modelo de testes de seleção representa o ranking do candidato no processo de seleção?**
*A27* Remete-se a resposta para a Q17 (responde indiretamente).

**Q28 – Pretende-se que cada Customer seja identificado no sistema como um utilizador?**
*A28* Remete-se a resposta para a Q6 (responde indiretamente).

**Q29 – Do ponto de vista do app file bot deve representar um serviço no sistema?**
*A29* Eu diria que sim, uma vez que é um processo que é necessário no sistema para transformar dados rececionados em formato que seja “reconhecido” pelo processo de recrutamento.

**Q30 – US2000b, o que é o enable/disable do candidato?**
*A30* (alguma referencia a Q23). Refere-se a desativar o acesso do candidato ao sistema(i.e., Candidate App)

**Q31 – Sobre a job specification, deve ser o cliente a enviar os requisitos ou é a responsabilidade do customer manager? Qual o conceito de uma job specification?**
*A31* (alguma referência a Q25). Tipicamente será o customer que informa o customer manager dos requisitos mínimos para uma oferta de emprego. O Customer manager verifica se existe já um requirements specification adequado. Caso não existe, com a ajuda do Language Engineer é criado um novo.

**Q32 – Os candidatos também têm estados associados? À medida que o processo avança, o estado do candidato também é atualizado?**
*A32* O estado é da candidatura. O avanço no processo pode não levar a “avanço” numa candidatura pois, por exemplo, no final do screening a candidatura pode ser rejeitada e, nesse caso, essa candidatura termina ai. Outras candidatura seguem o processo.

**Q33 – O candidato tem um código identificativo ou é o email que o identifica?**
*A33* A identificação do candidato é por email. Não haverá necessidade de um código.

**Q34 – US3002, lista job openings, position o que é?**
*A34* Nessa US quando referimos “position” tem o mesmo significado que “title or function” na secção 2.2.2.

**Q35 – Customer tem que ter morada e nome da empresa ou se basta essa informação estar no job opening?**
*A35* Devemos registar nome e morada do customer. Para cada job opening a morada pode ser especifica (e diferente da morada do customer).

**Q36 – US1021, o que é “all data of an application”? O que é uma job application?**
*A36* Uma job application é uma candidatura (de um candidato) a uma job opening. Relativamente ao “all data of na application” refere-se a todos os dados de uma candidatura, nomeadamente, os ficheiros submetidos pelos candidato assim como dados recolhidos ou gerados durante o processo (como as entrevistas e processamento de requisitos).