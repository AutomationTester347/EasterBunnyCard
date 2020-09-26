Feature: As a user, I can login with the valid credential
  so that I can access the Easter Bunny Card as a registered user

  @AutoTest @Test-001
  Scenario: Verify that user can login with valid credential
    Given I navigate to Home page
    Given "Home" page is presented
      | Page Title               | First Header                                            |
      | Home - Easter Bunny Card | Personal Easter Greetings with Mr Bunny video messages! |
    And I Click on the "Log In" link from top header
    And "Login" page is presented
      | Page Title                     | First Header |
      | My account - Easter Bunny Card | My Account. |
    When I enter Username as "qatester348" and Password as "one_2_three"
    When I click on the "Log in" button
    Then dashboard with username is appeared
