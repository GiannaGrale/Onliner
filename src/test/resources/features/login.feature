 #language: ru, en
 @Smoke
Feature: Sign in

  Background:
    Given Main page is opened

  Scenario: TC-1, Test to check if the entrance form opens
    When Open the entrance form
    Then Check if the entrance form was opened: "через социальные сети" appears

  @Ignore
  Scenario: TC-2.1, Test for registration of a new user
    When Open the entrance form
    And Click on the registration link
    And Set a new login
    And Set a new password
    And Accept the privacy policy
    And Click on the registration button
    Then A new user is registered:"Подтвердите ваш e-mail" appears

  Scenario Outline: TC-2, Test for login with correct credentials
    When Open the entrance form
    And Set the login "<username>"
    And Set the password "<password>"
    And Click on the entrance button
    Then The user is logged into the system
    Examples:
      | username            | password     |
      | vs2450439@gmail.com | hqhTqwje872H |

  Scenario Outline: TC-6, Test to check system behavior using the correct password and incorrect login
    When Open the entrance form
    And Set the login "<invalidUsername>"
    And Set the password "<password>"
    And Click on the entrance button
    Then The user failed to log in: "<expectedResult>" message appears
    Examples:
      | invalidUsername   | password     | expectedResult |
      | invalid@gmail.com | hqhTqwje872H | неверный логин или пароль |

  Scenario Outline: TC-8, Test to check system behavior using the correct login and incorrect password
    When Open the entrance form
    And Set the login "<username>"
    And Set the password "<invalidPassword>"
    And Click on the entrance button
    Then The user failed to log in: "<expectedResult>" message appears
    Examples:
      | username            | invalidPassword |expectedResult|
      | vs2450439@gmail.com | invalidPass1234 |неверный логин или пароль|

  Scenario: TC-7, Test to check system behavior using no credentials
    When Open the entrance form
    And Set the login ""
    And Set the password ""
    And Click on the entrance button
    Then Pops up a warning requiring to define the credentials: "укажите ник или e-mail"
