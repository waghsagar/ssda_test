How to run the Automated Test Suite,

Prerequisite
1.	Java environment
2.	Maven

Note: Configure important properties that required during test execution in data.properties file
1. Go to ssda_test\src\main\java\resources\data.properties 
2. Configure url, login credentials, etc in data.properties file

Project is ready to run. Execute following commands and enjoy the automatic web-driver test
•	Open Command prompt. Go to project path. For example: C:\Users\User-Name\ssda_test>
•	Run mvn clean
•	Run mvn compile
•	Run mvn test -Dbrowser=chrome	--> Change browser name in command as per intended test execution


After completing automated test execution, 
•	You can find the generated test execution html report at ssda_test\reports\SSDA_TestExecutionReport.html
•	You can find screenshots taken for failed testcases at ssda_test\screenshots \ 
•	You can find the generated logs generated during test execution at ssda_test\logs\SSDAloggerFile
