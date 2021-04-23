
Feature: Validate the functionality of add to cart and checkou

  Background: 
    Given User navigate to login page BigW
    And User enter valid ID and password in BigW login page
      | mukesh19rajish@gmail.com | Password@123 |
    And user search keyword in searchbox in my login page
      | keyword | phones |
    And User press enter button in keyboard for search and navigate to search result page
    And Select product in search result page
    And Click add to cart button and enter postcode in product page again click add to cart
@scenario4
  Scenario: 
    When User move mouse hover the cart icon
    And User click checkout buttton
    Then user should navigate to order summary page 
  
    
