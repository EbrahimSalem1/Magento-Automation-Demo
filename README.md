## Overveiw
- Test Automation Project for Magento Web App with Selenium WebDriver written by Java and based on Maven and TestNg
- Using Page Object Model Design Pattern in writing Test script and Page actions
- Test Data Management such that store All Test data in Json Files
- Generating Very Detailed Allure Reports with All Scenario Steps
- Performing with GitHub Actions (CI/CD) Tool

## Application Under Test
- Magento-SoftwareBoard
- https://magento.softwaretestingboard.com/


## Scenario (Task) :-
- Go to https://magento.softwaretestingboard.com/
- Create an account
- Navigate to Hot sellers in Home page
- Add 2 products to compare list

 
## Features
#### Structure of "main folder"
- Using the Method Handles Page as Parent of all pages that inherit locators and actions, Thus achieving the right purpose of Inheritance
- Finding Elements using simple Techniques with ID, CssSelector , XPath & Advanced Techniques

#### Structure of "test folder"
- Using Base Test Class for defining Annotations to Open and Close App, such that all Test Classes inherit from it
- Start each Test from a clean state by Setting and Tearing down App for Every Test Case
- Using Assertions to Validation of Tests


#### Reporting Using Allure Report
- Reporting Test Result & Taking Screenshots for Failed Tests and Successful Tests


#### Test Data Management
- Test Data Preparation for Json Data like ""registerData"" - ""hotSellersData"" by setting Json File
- Test Data Execution by reading test data from Json files whether Json data is represented as Simple Json Object

