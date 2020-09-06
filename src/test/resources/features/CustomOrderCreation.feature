Feature: As a user, I can create different type of custom order so that I can order a easter bunny video card

  Scenario: Verify that user can add and remove item from the cart
    Given "home" page is presented
    Given Easter Bunny Video Card page is presented
    When I select religious message type as "Religious"
    When I select the recipient name as "Amir"
    When I select special shout outs as "Alex"
    And I Click on the "Add To Cart" button
    Then I confirm the presence of order in cart page
    Then I remove the order
    And I confirm that order has been removed from the cart