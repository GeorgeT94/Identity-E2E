Feature: Checking Vehicle Data
  As a developer
  I want to check vheicle data by registration number
  So that I can confirm the vehicle information is valid

Scenario: Compare spreadsheet data to gov.uk data
  Given I have loaded spreadsheets containing vehicle data
  When I select files with the excel mime type
  Then I start the chrome driver
  Then I connect to the dvla website
  Then I enter vehicles reg numbers from excel sheet
  Then All the vehicles have valid registration numbers

