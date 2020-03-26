Feature: App configurations
  Background:
    Given the trainline app is opened in the settings screen

  Scenario: Change currency
    Given the current currency is "USD"
    When the currency is changed to EUR
    Then search results show prices in the new currency

  Scenario: Turn off notifications
    Given the push notifications are enabled
    When the notifications are turned off
    Then the app won't generate push notifications

  Scenario: Search FAQs for ticket refunds
    Given the contactFAQs screen is opened
    When the Ticket refunds and changes section is selected
    And the Travel in mainland Europe tag is selected
    Then the eight FAQs for Europe mainland ticket conditions are shown

