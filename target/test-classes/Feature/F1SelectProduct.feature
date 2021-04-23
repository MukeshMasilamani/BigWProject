Feature: Validate Product Searching Funtionlity and Add Cart

  Background: 
    Given User launch url of BigW home page

  @scenario1
  Scenario: check whether search results displayed should be relevant to  product for the search
    When user enter keyword in searchbox in home page
      | keyword | phones |
    And User click search button
    Then User navigate to search result page and Search results should be displayed relevant to keyword

  @scenario2
  Scenario: Verify that filtering functionality correctly filters products based on the filter applied
    When user search keyword in searchbox in home page
      | keyword | phones |
    And User click search button and User navigate to search result page
    And Scrolldown to brands filter area
    And click more brands in brands filter
    And select Apples brand in brands filter
    Then User get results should be displayed same as relevant to filter

  @scenario3
  Scenario: Verify user able to increase the quantity of the item in the product page
    When User navigate to login page
    And User enter valid ID and password in login page
      | mukesh19rajish@gmail.com | Password@123 |
    And user search keyword in searchbox in my account page
      | keyword | phones |
    And User press enter button keyboard for search and navigate to search result page
    And Select any one product in search result page
    And Click add to cart button
    And User increase quantity of item in product page
    Then User should be able to increase the quantity of item
    

    

    
    
    
    
    