Feature: Catalogue filters

  Background:
    Given Main page is opened
    And Catalogue is opened

  @Regression
  Scenario: TC-5, Test to choose a manufacturer in the filter
    When Smartphone catalogue details are selected
    And Brand is chosen
    Then Check if the page was filtered

  @Regression
  Scenario: TC-10, Test to check system behavior while entering negative start price for the goods
    When Pizza catalogue details are selected
    And Set a price "-60"
    Then Check the goods according to the price filter
