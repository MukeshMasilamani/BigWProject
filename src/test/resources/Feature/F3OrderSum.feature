Feature: Validate functionality in order summary page

  Background: 
    Given User should navigate to login page BigW
    And User should enter valid ID and password in login page of BigW
      | mukesh19rajish@gmail.com | Password@123 |
    And User move the cursor to  the cart icon and click checkout buttton

  @scenario5
  Scenario: Verify that enter the invalid promocode accept or not
    When user click promocode and enter invalid promocode
      | EMPTYY |
    And Click add button
    Then User should get error message
