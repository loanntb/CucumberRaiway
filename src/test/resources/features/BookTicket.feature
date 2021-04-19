Feature: Book ticket validation

    Scenario: Verify that the "Ticket booked successfully!" page displays correct information
        Given I navigate to Raiway website
        When I click on "Login" tab
        When I Login with username "<username>" and password "<password>"
        Examples:
            | username             | password  |
            | loan119044@gmail.com | 123456789 |
        Then "Logout" tab is displayed on the menu tab
        When I click on "Book ticket" tab
        When I select option from the dropdowns
            | Name          | Option  |
            | DEPART_DATE   | random  |
            | ARRIVE_AT     | random  |
            | DEPART_FROM   | random  |
            | SEAT_TYPE     | random  |
            | TICKET_AMOUNT | default |
