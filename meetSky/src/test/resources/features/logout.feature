@METSK-483
Feature: Logout Function
  User story : As a user, I should be able to log out.

  @METSK-481
  Scenario: Verify that user can log out and ends up in login page

    Given user is on the main page
    When user clicks on the user avatar
    And user clicks on logout
    Then user lands on login page

    @METSK-482
    Scenario: User can not go to home page again by clicking step back button after successfully logged out.

      Given user is on the main page
      When user logs out
      And user lands on login page
      Then user should not got to home page again by clicking back


