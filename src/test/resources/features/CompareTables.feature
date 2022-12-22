Feature: Compare the table contents between two different filtered tables

  @all @showRows
  Scenario: Users should be able to filter the coin table by 20
    Given open the coin market cap webpage
    When set the coin table by twenty
    Then the table should contain 20 coins

  @all @describePriceRange
  Scenario: Users should be able to describe price range to filter the coin tables
    Given open the coin market cap webpage
    When set the coin table by twenty
    Then capture all coin names in the table
    And click Algorithm
    Then select the PoW
    And click Add-filter
    Then toggle Mineable
    And click All Cryptocurrencies
    Then select Coins
    Then select price and set minimum value to "100" and maximum to "10,000"

  @all @compareNames
  Scenario: Users should be able to compare the names between two filtered tables
    Given open the coin market cap webpage
    When set the coin table by twenty
    Then capture all coin names in the table
    And click Algorithm
    Then select the PoW
    And click Add-filter
    Then toggle Mineable
    And click All Cryptocurrencies
    Then select Coins
    Then select price and set minimum value to "100" and maximum to "10,000"
    And the first filtered table should Not contain the coin names inside the second filtered table

  @all @compareTableSize
  Scenario: Users should be able to compare the size of different tables
    Given open the coin market cap webpage
    When set the coin table by twenty
    Then count the first table size
    And click Algorithm
    Then select the PoW
    And click Add-filter
    Then toggle Mineable
    And click All Cryptocurrencies
    Then select Coins
    Then select price and set minimum value to "100" and maximum to "10,000"
    Then coint the second table size
    And the filtered table should contain coins less than the first filtered table

  @all @compareTableHeaderNames
  Scenario: Users should be able to see the same headers for different tables
    Given open the coin market cap webpage
    When set the coin table by twenty
    Then capture the first table headers
    And click Algorithm
    Then select the PoW
    And click Add-filter
    Then toggle Mineable
    And click All Cryptocurrencies
    Then select Coins
    Then select price and set minimum value to "100" and maximum to "10,000"
    Then capture the second table headers
    And the filtered table should contain same header names with the first filtered table
