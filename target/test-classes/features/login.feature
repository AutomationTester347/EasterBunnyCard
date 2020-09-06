Feature: As a user, I can login with the valid credential
  so that I can access the Easter Bunny Card as a registered user

  Scenario: Verify that user can login with valid credential
    Given home page is presented
    Given login page is presented
    When I enter Username as "test32@test.com" and Password as "one_2_three"
    Then dashboard with username is appeared

    @34
    Scenario: Verify that user can't login with invalid credential
      Given home page is presented
      Given login page is presented
