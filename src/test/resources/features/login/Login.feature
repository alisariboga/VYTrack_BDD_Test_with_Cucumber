@VYT-4121
Feature: Login
  As user I want to login under different roles
# So hook will take care of this action
# Hook will open main page
#  Background:
#    Given user is on the landing page

  @storemanager
  Scenario: Login as a store manager
    Then user logs in as a store manager
    And user verifies that "Dashboard" page name is displayed


  @negative
  Scenario: Verify warning message for invalid credentials
    Then user logs in with "wrong" username and "wrong" password
    And user verifies that "Invalid user name or password." warning message is displayed


  @driver
  Scenario: Login as a driver
    Then user logs in as a driver
    And user verifies that "Quick Launchpad" page name is displayed


  @map_example
  Scenario: Login as different users
    Given user logs in with following credentials
      | username | salesmanager85 |
      | password | UserUser123    |
    Then user navigates to "Fleet" and "Vehicle Odometer"
    And user verifies that "Vehicles Odometers" page name is displayed

  @login_1
  Scenario Outline: login as different user tests
    Given user logs in as a "<user_type>"
    And user verifies that "<page name>" page name is displayed

    Examples:
      | user_type     |  | page name       |
      | driver        |  | Quick Launchpad |
      | sales manager |  | Dashboard       |
      | store manager |  | Dashboard       |

  @login_with_outline_2
  Scenario Outline: User names test
    Given user logs in with following credentials
      | username |  | <username> |
      | password |  | <password> |
    Then user name should be "<name>"


    Examples:
      | username        |  | password    | name              |
      | user187         |  | UserUser123 | Jerel Vandervort  |
      | user200         |  | UserUser123 | Lonzo Leuschke    |
      | storemaneger52  |  | UserUser123 | Roma Medhurst     |
      | storemaneger66  |  | UserUser123 | Carlos Ernser     |
      | salesmaneger125 |  | UserUser123 | Clevenland Heller |
      | salesmaneger140 |  | UserUser123 | Jameson Paucek9    |



