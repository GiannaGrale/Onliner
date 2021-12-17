Feature: Shopping Cart

  Background:
    Given Main page is opened

  @Smoke
  Scenario: TC-11, Test to check the entrance to the shopping cart
    And The shopping cart badge is clicked on
    Then Get the shopping cart label

  @Smoke
  Scenario: TC-4, Add an item to the shopping cart test
    And Catalogue is opened
    When Food catalogue details are selected
    And A food item is chosen from the catalogue list
    And The item is added to the cart
    And The shopping cart badge is clicked on
    Then Check if the item was added to the shopping cart
