@tag2
Feature: User Login
  As a returning user
  I want to log in to my account
  So that I can access my account information and shop

  @test1
  Scenario Outline: Successful login with valid credentials
     Given I am on the homepage using "<browser>"
     And I navigate to the login page
     When I enter my "<username>" and "<password>"
     And I click the Login button
     Then I should see a welcome message

   Examples: 
    | browser | username     | password  |
    | chrome  | PetStoreTest | 123456789 |
    | firefox | PetStoreTest | 123456789 |