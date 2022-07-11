
@METSK-480
Feature: Login Functionality

  @METSK-470
  Scenario: Log in with valid credentials
    Given User is on the login page
    When User enters valid username
    And User enters valid password
    And User should be able to click login button
    Then User should land on homepage

    @METSK-471
    Scenario: Unable to login with invalid username.
      Given User is on the login page
      When user enters invalid username
      And User enters valid password
      And User should be able to click login button
      Then User should see Wrong username or password message

      @METSK-472
      Scenario: Unable to login with invalid password.
        Given User is on the login page
        When User enters valid username
        And User enters invalid password
        And User should be able to click login button
        Then User should see Wrong username or password message

  @METSK-473
  Scenario: Unable to login if username placeholder is empty
    Given User is on the login page
    When User leaves username placeholder empty
    And User enters valid password
    And User should be able to click login button
    Then User should see Please fill out this field message in username box


        @METSK-474
          Scenario: Unable to login if password placeholder is empty
            Given User is on the login page
            When User enters valid username
            And User leaves password placeholder empty
            And User should be able to click login button
            Then User should see Please fill out this field message in password box


            @METSK-475
            Scenario: Password is in the form of dots by default
              Given User is on the login page
              When User enters valid username
              And User enters valid password
              Then User should see password text in the form of dots

              @METSK-476
              Scenario: Password can be seen explicitly if needed
                Given User is on the login page
                When User enters valid username
                And User enters valid password
                And User clicks on the eye icon inside the password placeholder
                Then User should be able to view the password text explicitly

                @METSK-477
                Scenario: Forgot Password link and Reset Password button can be seen
                  Given User is on the login page
                  When User clicks on forgot password link
                  And User lands on next page
                  Then User can see reset password button

                 @METSK-478
                  Scenario: Username placeholder is visible
                    Given User is on the login page
                    Then User can see username placeholder

                   @METSK-479
                   Scenario: Password placeholder is visible
                     Given User is on the login page
                     Then User can see password placeholder

























