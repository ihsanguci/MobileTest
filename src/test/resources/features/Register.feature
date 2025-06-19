Feature: Wallet Creation

  @TC1
  Scenario Outline: User successfully create a new wallet
    Given User Already in main screen
    When register User click btnCreate
    And User generate password <password>
    And User generate password <password>
    And register User click btnSkip
    Then register User verify element is visible txtSuccess
    And register User verify text <text> using locator txtSuccess
    Examples:
      | password | text                             |
      | 3281923  | Brilliant, your wallet is ready! |