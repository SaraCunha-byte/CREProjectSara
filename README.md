Frameworks used: Selenium, Cucumber
Testing framework: TestNG, Allure Report, JUnit
Programming language: JAVA
Build tool: Maven
CI/CD Tool: Jenkins
Repository: GitHub
Website used: https://petstore.octoperf.com/actions/Catalog.action

Tests required:
•	User registration
•	User login
•	Search and check details of products
•	Add product to cart
•	Prochase a product

As I have converted the project to Testng, to run the tests, please use the “mvn clean test” command on the project terminal itself. The “Run as Cucumber feature” command Will no longer work.
I have commented the tag line in the Test runner so I could run all tests in a row. Remove the comment to run just one of the tests and choose the corresponding tag present in each of the features.

The goal was to use the Page Object Model, so I implemented each feature independently and they can be run as an independent test. I have reused the relevant code so that the code is easier to maintain and improve as time goes by. Each feature has a corresponding scenario written using Gherkin language.

I have created classes that would help me reuse code that repeated itself throughout the project, like the HomePageSteps, the RandomCredentialsGenerator and the TestWebDriver classes.
