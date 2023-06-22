@navigation
Feature: Navigation menu options
  As user I want to use top menu for navigation

  Background:
    Given user is on the landing page
    When user logs in as a "driver"
#   instead of driver, I would put admin super user
#   who has access to every component of the application
#   driver has access only to certain modules

  Scenario: Login as a driver and navigate to the Vehicles
    Then user navigates to "Fleet" and "Vehicles"
    And user verifies that "Cars" page name is displayed

  Scenario: Login as a driver and navigate to the Vehicles Odometer
    Then user navigates to "Fleet" and "Vehicles Odometer"
    And user verifies that "Vehicle Odometers" page name is displayed