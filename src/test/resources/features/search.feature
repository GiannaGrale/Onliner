@Regression
Feature: Search Field

  Scenario: TC-9, Test to check the input hint while entering nonexistent item
    Given Main page is opened
    And A random query is inserted into the search field
    Then Check whether an item was found with the query: "ничего не найдено" pops up
    And  Check if the query was inserted into the search field
