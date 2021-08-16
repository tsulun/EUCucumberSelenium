@login
Feature: Users should be able to login

  Background:
    Given the user is on the login page

  @driver
  Scenario: Login as a driver

    When the user enters the driver information
    Then the user should be able to login

  @sales_manager
  Scenario:  Login as a sales manager

    When the user enters the sales manager information
    Then the user should be able to login

  @store_manager
  Scenario: Login as a store manager

    When the user enters the store manager information
    Then the user should be able to login


  @NAVF-258
    #User can not login with any invalid credentials
  Scenario Outline:  Login as with invalid credentials
    When user enters invalid "<username>" and "<password>"
    Then the user should not be able to login
    Examples:
      | username  | password    |
      | user123   | user123user |
      | user10001 | UserUSer123 |

  @NAVF-259
    #User should see the password in bullet signs by default
  Scenario: bullet sign visibility check
    Then User should see the password in bullet signs

  @NAVF-260
    #User can see and click an option link like "remember me" on the login page
  Scenario: Click on remember me on the login page
    When User clicks on remember me box
    Then User can see an option link like remember me on the login page
    Then User can click an option link like remember me on the login page

  @NAVF-261
  #User can see and use an option link like "forgot password"
  Scenario:forgot password button visibility and usability check
    Then User can see and use an option link like "forgot password" on the login page in order to successfully reset the password



