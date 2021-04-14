Feature: RegisterFeature

    Background:
        Given I navigate to Raiway website
        When I click on "Register" tab

    Scenario:  Verify that user cannot create new account using Email that has been registered
        When I register a create new account using Email that has been registered with the following data below
            | email              | password  | confirmPassword | pid      |
            | abc76088@gmail.com | 123456789 | 123456789       | 12345678 |
        Then The error message  "This email address is already in use." is displayed on the screen



