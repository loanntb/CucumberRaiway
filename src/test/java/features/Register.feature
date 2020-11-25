Feature: RegisterFeature
    Scenario Outline: Verify user can register with valid data
        When Click on register tab
        When Register the Email "<email>"  Password "<password>"  Confirm Password "<confirmPassword>" PID "<pid>"
        Then Getting an information register successfully message
        Examples:
            | email                   | password  | confirmPassword  | pid |
            | abc4777755@gmail.com    | 123456789 | 123456789        |12345678|
