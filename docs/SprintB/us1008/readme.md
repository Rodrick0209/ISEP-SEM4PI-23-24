# US 1008

## 1. Context

This task, identified as "US 1008", is being assigned for the first time. The context for this task is to deploy and configure a plugin of a Job Requirement Specification or Interview Model.

## 2. Requirements

**US 1008** As Language Engineer, I want to deploy and configure a plugin (i.e., Job Require-
ment Specification or Interview Model) to be used by the system.

**Dependencies/References:**

- NFR09(LPROG) - Requirement Specifications and Interview Models The support
  for this functionality must follow specific technical requirements, specified in LPROG.
  The ANTLR tool should be used (https://www.antlr.org/).

## 3. Analysis

### Client meeting

-  Admite-se que os modelos quando são registados no sistema (os tais “plugins”) ficam identificados com um nome ou descrição. Por exemplo “Modelo de Entrevista para Operador de Caixa de Supermercado” ou “Modelo de Entrevista para Programador Junior Backend Java”.
- O language enginner com informação passada pelo customer manager (que obteve do customer) vai desenvolver em java um jar correspondente ao modulo/plugin. Para esse desenvolvimento terá de utilizar técnicas de desenvolvimento de gramáticas/linguagens como o antlr. Esse código ficará num jar que depois o language engineer “instala/regista” na aplicação (US1008, por exemplo, associando um nome ao jar num ficheiro de configuração – “5 anos experiencia java”, “req-model-5-years-java.jar”). A aplicação com essa informação carrega dinamicamente esse jar. Na gramátca usada no jar é que vão estar espelhadas a estrutura das perguntas a usar nesse modelo e sua avaliação. Estas atividades têm de ser feitas antes de se poder fazer a US1008. Esse trabalho é feito “fora” dos sistema, apenas se registando o modelo (quando está pronto) na US1008. A US 1009 e US1011 permitem selecionar modelos a usar (dos que foram devidamente registados no sistema).
- As perguntas são as mesmas para todos os candidatos a um job opening. As questões e as notas são definidas pelo Customer Manager em colaboração com o Customer.


### Business Rules

- This US is directly related to the users of the backoffice.
- To deploy and configure a plugin for Interview Model and Job Requirement the user must be a language engineer.
- The user must have an email, name, and password.
- The plugin must be identified by a name.

## 4. Design

### 4.1. Realization


### 4.2. Class Diagram


### 4.3. Applied Patterns

In the development of this task, we utilized several design patterns to structure our code and ensure its
maintainability and scalability. These patterns include:


- **Repository Pattern:** The Repository pattern was used to create an abstraction layer between the data access layer
  and the business logic layer of the application. This helps to decouple the application and make it easier to maintain
  and test.
- **Controller Pattern:** The Controller pattern was used in the presentation layer of the application. Controllers
  handle incoming requests, manipulate data using the model, and select views to render to the user

### 4.4. Tests

## 5. Implementation

### 5.1. For a Job Requirement Specification Plugin 

The process of deploy and configure a Job Requirement Specification plugin in this system involves several components working together. Here's a step-by-step
explanation

- **User Interface (ConfigureJobRequirementPluginUI.java)**: The process starts in the ConfigureJobRequirementPluginUI class, which is
  responsible for interacting
  with the user. It prompts the user to enter the necessary information.
  This class uses the ConfigureJobRequirementPluginController to handle the business logic.
- **Controller (ConfigureJobRequirementPluginController.java):** The ConfigureJobRequirementPluginController class is the bridge between the
  UI and the business
  logic.
- **Repository (JobRequirementSpecificationRepository):** The JobRequirementSpecificationRepository is an interface that defines the methods for
  interacting with the
  database. It extends the DomainRepository interface, which provides methods for basic CRUD operations.

### 5.2. For a Interview Model Specification Plugin

The process of deploy and configure a Interview Model Specification plugin in this system involves several components working together. Here's a step-by-step
explanation

- **User Interface (ConfigureInterviewModelPluginUI.java)**: The process starts in the ConfigureInterviewModelPluginUI class, which is
  responsible for interacting
  with the user. It prompts the user to enter the necessary information.
  This class uses the ConfigureInterviewModelPluginController to handle the business logic.
- **Controller (ConfigureInterviewModelPluginController.java):** The ConfigureJobRequirementPluginController class is the bridge between the
  UI and the business
  logic.
- **Repository (InterviewModelSpecificationRepository):** The JobRequirementSpecificationRepository is an interface that defines the methods for
  interacting with the
  database. It extends the DomainRepository interface, which provides methods for basic CRUD operations.

## 6. Integration/Demonstration

### Integration

We seamlessly integrated our functionality by leveraging an existing service that included both a repository and a
controller. This approach allowed us to efficiently integrate our solution into the system without duplicating efforts
or reinventing existing components.

### Demonstration

To demonstrate the functionality follow the steps below:

#### 1. Deploying the plugin

- Move the jar file to the **target/dependency** path.

#### 2. Registering/configuring the plugin

**For a Job Requirement Specification Plugin**

- Start the application and log in as a language engineer.
- Navigate to the plugins section.
- Select the configure a Job Requirement Specification plugin option.
- Input the name for the Plugin.
- Input the class name that initializes the Plugin. 

**For a Interview Model Specification Plugin**

- Start the application and log in as a language engineer.
- Navigate to the plugins section.
- Select the configure a Interview Model Specification plugin option.
- Input the name for the Plugin.
- Input the class that initializes the Plugin.

## 7. Observations

- In this document, only has present the part of deploying and registering the plugin in the system. The "build-up" of the jar file in the plugin is outside the scope of the project, where has ANTLR grammars and internal plugin classes.