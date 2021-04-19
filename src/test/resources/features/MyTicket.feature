Feature: My ticket validation

    Scenario Outline: Verify that total tickets in the table must match with the message in the Note
        Given I navigate to Raiway website
        When I click on "Login" tab
        And I Login with username "<username>" and password "<password>"
            | username             | password  |
            | loan119044@gmail.com | 123456789 |

        Examples:
            |  |