# Project Jobs4U

## 1. Description of the Project

Jobs4U is a company specialized in talent acquisition, providing recruitment services for job positions in its clients. The aim of this project is to develop a solution that automates the main activities of the company, with a minimum viable product to be developed in 3 months.

The company’s clients are other companies or entities that need to recruit human resources. In response to requests from its clients, Jobs4U develops all activities that allow it to select a set of candidates for job offers. At the end of the process, Jobs4U delivers to its client an ordered list of candidates for each job offer. The final recruitment decision is the responsibility of the client.

The system administrator (Admin) is responsible for managing customer entities as well as the company’s employees who are customer managers. This responsibility involves registering entities as well as assigning different roles to system users.

Entities send job offers to Jobs4U. A customer manager will register job offers for the entities he manages in the backoffice. The customer manager will also manage other aspects of job offers, namely the entire candidate selection process. However, the registration of candidates for job offers is carried out by the operators (using some bots to automate the process).

The operator is a company employee whose main responsibility is to monitor the automatic process that registers applications for job offers. These applications are received by email and processed automatically by the Applications Email Bot. The Operator should monitor this process, especially the report files that are produced. The Operator may, eventually, contact candidates if problems exist in their applications.

Both candidates and clients have specific applications (console applications) that basically allow them to monitor applications and job offers and receive notifications about them.

The selection of candidates is highly based on automated processes (such as interviews or verification of application requirements) that require the production of plugins (for the Backoffice application) by a Language Engineer. These plugins automate the processing of job interviews and application requirements by applying language processing, that maybe specific for each job opening.

## 2. Planning and Technical Documentation

[Planning and Technical Documentation](docs/readme.md)

## 3. How to Build

1. Ensure that Maven is installed on your system. You can check this by running the command `mvn -v` in your terminal. If Maven is not installed, you can download it from the [official Apache Maven website](https://maven.apache.org/download.cgi).

2. Add Maven to your system's PATH. The process for this varies depending on your operating system. For macOS and Linux, you can add the following line to your `.bashrc` or `.bash_profile` file:

    ```bash
    export PATH=/path/to/your/maven/bin:$PATH
    ```

   Replace `/path/to/your/maven/bin` with the actual path to your Maven `bin` directory. For Windows, you can add the path to your Maven `bin` directory to your system's PATH variable through the System Properties.

3. Once Maven is set up, you can build the project by running the `build-all.bat` script if you're on Windows, or `build-all.sh` script if you're on macOS or Linux. These scripts will use Maven to compile the project and build a JAR file. To run the script, navigate to the project directory in your terminal and run:

    ```bash
    ./build-all.bat
    ```

   or

    ```bash
    ./build-all.sh
    ```

   depending on your operating system.

## 4. How to Execute Tests

1. Ensure that Maven is installed and set up on your system as described in the "How to Build" section.

2. To run the tests, navigate to the project directory in your terminal and run the following command:

    ```bash
    mvn test
    ```

    This command will compile the project and run all tests. The results of the tests will be displayed in the terminal.

3. If you want to run a specific test, you can do so by specifying the test class and method in the following format:

    ```bash
    mvn -Dtest=TestClassName#methodName test
    ```

    Replace `TestClassName` with the name of your test class and `methodName` with the name of the method you want to test.

4. After the tests have run, you can find detailed reports in the `target/surefire-reports` directory of your project.

## 5. How to Run

1. After building the project as described in the "How to Build" section, a JAR file will be created in the `target` directory of your project.

2. To run the application, navigate to the `target` directory in your terminal and run the following command:

    ```bash
    java -jar your-jar-file.jar
    ```

    Replace `your-jar-file.jar` with the actual name of your JAR file.

3. The application should now start and you can interact with it through the terminal.

Please note that the application may require certain environment variables to be set or specific arguments to be passed in. If that's the case, please refer to the application's documentation or source code to determine what's needed.

## 6. How to Install/Deploy into Another Machine (or Virtual Machine)

1. After building the project as described in the "How to Build" section, a JAR file will be created in the `target` directory of your project.

2. Copy the JAR file to the machine or virtual machine where you want to deploy the application. You can do this using a secure copy (scp) command, a USB drive, or any other method you prefer.

    ```bash
    scp your-jar-file.jar user@your.server:/path/to/deploy/directory
    ```

    Replace `your-jar-file.jar` with the actual name of your JAR file, `user@your.server` with your username and server address, and `/path/to/deploy/directory` with the directory where you want to deploy the application.

3. On the target machine or virtual machine, ensure that Java is installed. You can check this by running the command `java -version` in the terminal. If Java is not installed, you can download it from the [official Oracle Java website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

4. Navigate to the directory where you deployed the JAR file and run the application with the following command:

    ```bash
    java -jar your-jar-file.jar
    ```

    Replace `your-jar-file.jar` with the actual name of your JAR file.

5. The application should now start and you can interact with it through the terminal.

Please note that the application may require certain environment variables to be set or specific arguments to be passed in. If that's the case, please refer to the application's documentation or source code to determine what's needed.4. If the build is successful, you should see a `BUILD SUCCESS` message in your terminal, and a JAR file will be created in the `target` directory of your project.


## 7. How to Generate PlantUML Diagrams

To generate plantuml diagrams for documentation execute the script (for the moment, only for linux/unix/macos):

    ./generate-plantuml-diagrams.sh


