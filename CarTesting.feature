Feature: Checking Vehicle Data
  As a developer
  I want to check vheicle data by registration number
  So that I can confirm the vehicle information is valid

Scenario: Compare spreadsheet data to gov.uk data
  Given I have loaded spreadsheets containing vehicle data
  When I run the checkValidVehicle method
  Then I am returned a list of valid vehicles

