# APIFramework
This Framework is build for Rest API Automation testing Using Cucumber framework

# Tools and Framework Used:

- Rest-Assured
- Maven repository
- Cucumber
- Jackson

# Main Features

- BDD framework to test automation Webservices. It is feature file driven framework with predefined Json Payload POJO classes and mapped using stepdefination files for individual feature steps.
- You can validate the returned response body, headers and cookies.
- Supports REST webservices testing.
- All classes and methods are implemented in Java with Maven repository to include all dependencies needed. REST-Assured is used to offer a friendly DSL (Domain specific Languages) that describes a connection to an HTTP endpoint and expected results.
- Utilizes the capabilities of Cucumber flexible test suites configuration and management. Created 2 types of html report.
  - The Default HTML reports are very descriptive with good statistics reports that can be integrated with Jenkins after test execution to have summary status of each deployment. located at:target/cucumber-reports.html
  - Using extra Plugin: Customised Multiple HTML Report Located at: target/cucumber-html-reports/*.html
- You Can use @tags for different scenario execution.

# Scenario Covered
- @CreateBooking: Verify CreateBooking Api if user is able to succeefully place booking using create booking api.
- @GetBooking: Verify GetBooking Api if user is able to succeessfully get booking using create booking api.
- @DeleteBooking: Verify DeleteBooking Api if user is able to succeefully Delete booking using create booking api.

# Execution using command promt
- You can use below commands to execute repective feature scenrio or all at once.
- Please find below commands:
   - To run all feature scenrios: mvn test 
   - To run individual scenario: mvn test -Dcucumber.options="--tags @CreateBooking" OR mvn test -Dcucumber.options="--tags @GetBooking" OR mvn test -Dcucumber.options="--tags @DeleteBooking"

# Reports:
2 Types of reports get generated:
- The Default HTML reports are very descriptive with good statistics reports that can be integrated with Jenkins after test execution to have summary status of each deployment. located at:target/cucumber-reports.html
- Using extra Plugin: Customised Multiple HTML Report Located at: target/cucumber-html-reports/*.html

![image](https://github.com/rishabhdesire/APIFramework/assets/74549534/d6e83971-0a83-4686-ae54-bcb65f2af189)


# Log Files:
Log file is getting generated to trace the logs located at: target/logging.txt
  



