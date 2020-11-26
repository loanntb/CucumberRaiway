Feature: LoginFeature

    Scenario Outline: Login with a username and an invalid password
        When Click Login tab
        When Login with Username "<username>" and Password "<password>"
        Then Login successfully

        Examples:
            | username             | password  |
            | loan119044@gmail.com | 123456789 |
            | hello@gmail.com      | 123456789 |

    Scenario Outline: Login with invalid username and password
        When Click Login tab
        When Login with Username "<username>" and Password "<password>"
        Then Getting login failed error message
        Examples:
            | username             | password  |
            | loan119044@gmail.com | wrongpassword |

    Scenario: Login with all blank username and password
        When Click Login tab
        When Login with Username "" and Password ""
        Then Getting login failed error messages

