Feature:As a user I should be able to log out

  @NAVF-266
  Scenario Outline: logout with different users
    Given the user logged in as "<userType>"
    Then the user should be able to login
    Then the user should be able to logout
    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |



