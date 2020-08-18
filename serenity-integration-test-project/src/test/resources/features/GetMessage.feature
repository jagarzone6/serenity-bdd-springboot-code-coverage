Feature: Get message

  @current
  Scenario: Get message from API
    Given The service is up
    When I ask for the user message
    Then I should see message "Greetings from Spring Boot!"
