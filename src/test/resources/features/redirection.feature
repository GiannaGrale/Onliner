@Smoke
Feature: Redirection

  Scenario: TC-3, Test to check redirection to 'About' page"
    Given Main page is opened
    When Click on 'About company' link
    Then Check if the page was opened:"о сайте" label appears
