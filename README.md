# Finding Hospital
This project utilizes a hybrid framework in Selenium with Java, implementing the Page Object Model (POM), reports, logs, extent report, and loggers.

## Requirements
####  1. Search Doctors

•	Location: Bangalore

•	Speciality: Dentist

•	Filters:

o	Patient Stories

o	Experience

o	Fees

o	Availability

•	Sorting: Any one method

•	Display: Fetch and display details of the first 5 doctors.

####  2. Extract Surgeries

•	Navigate to the “surgeries” section.

•	Extract and store all surgeries in a list.

•	Display the list in console output.

####  3. Corporate Health and Wellness Plan

•	Under “For Corporate -> Health and Wellness plan”

o	Fill the form with:

	Invalid email ID.

	Valid details for other fields.

o	Validate if the “Taking a demo” button is displayed.

o	Print the observation in console output.

o	Provide a valid email format, click the button, and validate if the “Thank you” message is displayed.

## Implementation Details

•	Framework: Hybrid Framework in Selenium with Java

•	Design Pattern: Page Object Model (POM)

•	Reporting: Extent Report

•	Logging: Logs and Loggers

## Setup Instructions
•	Ensure you have Java and maven installed.

•	Set up the selenium WebDriver for your preferred browser.

•	Update the project dependencies.

• Update Maven Compiler & Surefire plugins in pom.xml. 

•	Execute the test cases.

## Usage
•	Run the test suite.

•	Review the console output for search results, surgery list, and validation messages.

•	Check the Extent Report for detailed test execution results.

•	Log files provide additional insights and troubleshooting information.

## How to run
*You can run the project in different ways:*

•	Using the pom.xml file: Right-click on the pom.xml file and select ‘Run as Maven test’.

•	Using pom.xml: Right-click on the main.xml file and select ‘Run as TestNG Suite'.

•	Using the command prompt: Navigate to the project directory and execute the command ‘mvn test’.

•	Using the batch file: Double-click on the run.bat file in the project directory.

## Author Information
•	Nitish Patilkulkarni - 2303559


## Disclaimer
This project is intended for educational and testing purposes only. The authors are not responsible for any unauthorized use or modification of the code. Use at your own risk.

