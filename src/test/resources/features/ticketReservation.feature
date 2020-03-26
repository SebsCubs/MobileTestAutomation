Feature: Ticket reservation

  Scenario: Search train tickets
    Given the search screen is opened
    When a search for a train ticket from "Torino" to "Milano" is made
    Then a new screen with ticket results sorted by price is shown