**Selenium course Level 2 - Build framework Loanntb**
* [Install](#install)
    + [Prerequisite](#prerequisite)
    + [Setup](#setup)
* [Run Tests](#runtest)
* [Test results](#testresults)
    ## Install
    ### Prerequisite
    Below applications are required
    - [IntelliJ IDEA](https://www.jetbrains.com/idea/)
    - [Maven](https://maven.apache.org/install.html) 
    - [JDK 8](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html)
    
    ### Setup
    
    1. Download source code
    2. Start IntelliJ, `File` -> `Open` -> select `CucumberRaiway/pom.xml` and choose `Open as Project` option
    3. Wait for IntelliJ to install all the dependencies from the pom file, if it doesn't or you encounter any error, right click on the pom file, select `Maven` -> `Reimport`
    4. Install all plugins below:
    - Cucumber for Java
    - Gherkin
    - Lombok
    
## Run Tests
### Setting
`Edit configuration` -> `suite` option -> `testng.xml` file -> `Apply`
#### Run test by suite files
For each scenario, I have a dedicated suite created for it. Just right click on it and click `Run` to execute the test.

### Test results
- Allure-cucumber
- HTML test results can be found at [target](allure-results)  