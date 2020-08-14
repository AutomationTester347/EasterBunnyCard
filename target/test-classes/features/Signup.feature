Feature: As a new user, I can register a new account
  so that I can access the Easter Bunny Card as a registered user

  Scenario: Verify that user can register a new account by using signup form
    Given home page is presented
    Given login page is presented
    When user fillup the registration form with valid information
    And click on the Register button
    Then dashboard with username is appeared

