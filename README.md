# Identity E2E

## Goals
The goal of this project was to test car information found in spreadsheet documents and check how it compares to the information found on the DVLA website.

## Method
This is a project takes files found in src/main/resources. https://github.com/GeorgeT94/Identity-E2E/tree/master/Identity-E2E-Project/src/main/resources/TestFiles

It then searches for files with the correct mime-type of a spreadsheet document.

It then opens these files and converts the row data into a java car object.

Then using selenium a chrome browser is opened and taken to the dvla webpage.

The car registration number is then entered and the results are compared to the properties of the java object.

## Test results

### Here is the test results of the cucumber stepfile:

![Screenshot](https://imgur.com/LMaOkLZ.png)

## How to run

Clone the repository 

```
  git clone https://github.com/GeorgeT94/Identity-E2E.git
  ```
  
  Download a chromedriver and save to "C:\chromedriver_win32\chromedriver.exe"
  Or change the path in "Page_DVLA.java" to your existing chromedriver
  
  Run maven install to build the project
  
  Run "TestRunner_VehicleCheck" class as a junit test in order to run through the step definition file.
  
