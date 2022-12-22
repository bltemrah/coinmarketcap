# QA TASK
### Compare the table content between the first filtered table and the second filtered table

The four different scenarios have been created to compare two different tables by filtering options displayed in UI.

The web page is https://coinmarketcap.com

All scenarios are based on the below steps;
- Go to the above web page, https://coinmarketcap.com
- Set the rows by 20
- Filter "PoW" in the Algorithm
- Follow "Add Filter"
- Toggle "Mineable"
- Select "All Cryptocurrencies"
- Select "Coins"
- Set the minimum value at 100 and the maximum to 10,000

### Key Features

- Framework: Cucumber BDD framework with Gherkin DSL
- Software language: Java 13
- Project build: Maven
- Library: Cucumber JUnit
- Automation web-element: Selenium
- Architect: Page Object Model (Multi layer object)

### Definition

- All related dependencies and plugin added in the **"pom.xml"** file
- I use **configuration.properties** file to manage data such as url or credentials in one place, and call it by helping **ConfigurationReader** class
- All test scenarios are under **CompageTables** feature under feature folder
- **CukesRunner** class is under runners folder to execute a specific test scenario(s) by using their tag(s)
- In the **pages** folder,there are three different folders; 
  - **commons** that includes **CommonActions** class in where I put some java methods for common acctions
  - **pageActions** that includes **MainPagesActions** in where I put different java methods for the first/main page actions
  - **pageLocators** that includes **MainPageLocators** in where I put all locators of the first/main page
- I use inheritance OOP concept to extend **CommonActions** and **MainPageActions**
- The **MainPageStepDefinitions** class has all assertions and calls action methods from **MainPagesActions** and **MainPageLocators** 
- **Hooks** class has all @Before and @After action such as setup and close.
- Because I work only one page, I prefer inheritance OOP concept to extend **MainPageStepDefinitions** with **MainPagesActions**. However, it is also possible to use constructor with object. 

### Test scenarios

  To compare two different filtered tables, I created the below scenarios;

- **Scenario 1 (@showRows):** Users should be able to filter the coin table by 20 
- **Scenario 2 (@describePriceRange):** Users should be able to describe price range to filter the coin tables
- **Scenario 3 (@compareNames):** Users should be able to compare the names between two filtered tables
- **Scenario 4 (@compareTableSize):** Users should be able to compare the size of different tables
- **Scenario 5 (@compareTableHeaderNames):** Users should be able to see the same headers for different tables