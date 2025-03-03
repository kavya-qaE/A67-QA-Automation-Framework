Feature: Login Feature

  Scenario: Login Success
    Given I open Login page
    When I enter  email "kavya.ilapavuluri@gmail.com"
    And I enter  password "student#67"
    And I click submit
    Then I logged in