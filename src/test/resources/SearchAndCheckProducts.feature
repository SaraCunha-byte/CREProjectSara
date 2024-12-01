@tag3
Feature: Search and Visualize Item
  As a user
  I want to search for a product
  So that I can see the details of an item I am interested in buying

  @test1
  Scenario Outline: Successful search for an existing product
    Given I am on the homepage using "<browser>"
    When I enter "<searchTerm>" in the search bar
    And I click the Search button
    Then I should see a list of products related to "<searchTerm>"
    
    Examples: 
      | browser | searchTerm  |
      | chrome  | dog food    |
      | firefox | dog food    |

 @test2
Scenario Outline: Correctly viewing product details
   Given I am on the homepage using "<browser>"
   And I searched for "<searchTerm>" and results are displayed
   When I click on the first item
   Then I should be redirected to the product details page
   
    Examples:
     | browser | searchTerm  |
     | chrome  | dog food    |
     | firefox | dog food    |
