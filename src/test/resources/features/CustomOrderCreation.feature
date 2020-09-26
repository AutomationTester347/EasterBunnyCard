@AutoTest
Feature: As a user, I can create different type of custom order so that I can order a easter bunny video card

  @Test-002
  Scenario: Verify that user can checkout an order
    Given I navigate to Home page
    Given "Home" page is presented
      | Page Title               | First Header                                            |
      | Home - Easter Bunny Card | Personal Easter Greetings with Mr Bunny video messages! |
    And I Click on the "Order Now" from top navigation bar
    And "Easter Bunny Video Card" page is presented
      | Page Title                                  | First Header             |
      | Easter Bunny Video Card - Easter Bunny Card | Design Your Custom Order |
    When I fill custom order form with the following information
      | Field Name     | Value           |
      | Message Type   | RELIGIOUS       |
      | Recipient Name | Amelia          |
      | Shout Outs     | Adrian, Ainsley |
    When I click on the "Add to cart" button
    When "Cart" page is presented
      | Page Title               | First Header |
      | Cart - Easter Bunny Card | Your Cart    |
    And I confirm the presence of order
    And I apply this cupon code "FREE2020"
    And I click on the "Proceed to checkout" button
    And "Checkout" page is presented
      | Page Title                   | First Header |
      | Checkout - Easter Bunny Card | Check Out.   |
    And I confirm the presence of order
    And I fill the billing address with the following details
      | Field Name       | Value                     |
      | First name       | Marko                     |
      | Last name        | Vujatov                   |
      | Country / Region | United States (US)        |
      | Street address   | 10/A                      |
      | Town / City      | Los Angeles               |
      | State            | California                |
      | Email address    | easterbunnycard@gmail.com |
    And I agree with the website terms and conditions
    And I click on the "Place order" button
    Then "Order Confirmation" page is presented
      | Page Title                   | First Header        |
      | Checkout - Easter Bunny Card | Order Confirmation. |
    Then I confirm the presence of order
    Then I verify that the order confirmation message is "Thank you. Your order has been received."


