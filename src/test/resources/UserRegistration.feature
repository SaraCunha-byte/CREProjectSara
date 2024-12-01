@tag1
Feature: New User Registration
  As a new user
  I wnt to register an account
  So that I can shop for pet products

  @test1
  Scenario Outline: Successful user registration
    Given I am on the homepage using "<browser>"
    And I navigate to the Account registration page
    When I fill out the required account information with valid values
    And I click the Save Account Information button
    Then I should be redirected to the home page
    
    Examples: 
      | browser |
      | chrome  |
      | firefox |