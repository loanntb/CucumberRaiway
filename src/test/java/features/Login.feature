Feature: LoginFeature

    Scenario Outline: Login with a username and an invalid password
        When Click Login tab
        When Enter the Username "<username>" and Password "<password>"
        Then Login successfully

        Examples:
            | username             | password  |
            | loan119044@gmail.com | 123456789 |

    Scenario Outline: Login with invalid username and password
        When Open Login tab
        When Enter the Username "<username>" and an invalid Password "<password>"
        Then User gets login failed error message
        Examples:
            | username             | password  |
            | loan119044@gmail.com | wrongpassword |