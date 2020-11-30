Feature: LoginFeature

    Background:
        Given I navigate to Raiway website
        When I click on "Login" tab

    Scenario Outline: Login with valid username and  password
        When I Login with username "<username>" and password "<password>"
        Then Logout tab is displayed on the menu tab
        Examples:
            | username             | password  |
            | loan119044@gmail.com | 123456789 |
            | hello@gmail.com      | 123456789 |

    Scenario Outline: Login with invalid username and password
        When I Login with username "<username>" and a wrong password "<password>"
        Then The error message "Invalid username or password. Please try again." is displayed on the screen
        Examples:
            | username             | password      |
            | loan119044@gmail.com | wrongpassword |

    Scenario: Login with all blank username and password
        When Login with username "" and password ""
        Then The system displays the messages below
            | formMessage               | userMessage  | passwordMessage |
            |There was a problem with your login and/or errors exist in your form.|You must specify a username.|You must specify a password." are displayed on the screen|

