Feature: Contacts page

  Scenario:Default page number
    Given the user is on the login page
    And the user enters the driver information
    When the user navigates to "Customers" "Contacts"
    Then default page number should be 2


  Scenario: Verify Create Calender Event
    Given the user is on the login page
    And the user enters the sales manager information
    When the user navigates to "Activities" "Calendar Events"
    Then the title contains "Calendar"
   #added "s" at the end of calendar to fail

  Scenario: Menu Options Driver
    Given the user logged in as "driver"
    Then the user should see following options
      | Fleet      |
      | Customers  |
      | Activities |
      | System     |

  Scenario: Menu Options Sales Manager
    Given the user logged in as "sales manager"
    Then the user should see following options
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |

  Scenario Outline: login as a given user <user>
    Given the user is on the login page
    When the user logs in using following credentials
      | username  | <user>      |
      | password  | UserUser123 |
      | firstname | <firstName> |
      | lastname  | <lastName>  |
    Then the user should be able to login

    Examples:
      | user           | firstName | lastName  |
      | user10         | Brenden   | Schneider |
      | storemanager85 | Stephan   | Haley     |

#    ctrl + ? for create multiple comments line