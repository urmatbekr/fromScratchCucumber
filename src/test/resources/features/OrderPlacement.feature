@regression
Feature: Testing Item Purchase Functionality of the SauceDemo

  Scenario Outline: Validating Order Functionality is working for an item.(Happy Path)
    Given User provides username and password to login successfully
    When User chooses the '<productName>',click add to cart button and validate it is added
    And User clicks cart icon and checkout button
    And User provides '<firstName>','<lastName>','<zipCode>' to checkout page and click continue button
    Then User validates the '<productName>','<itemTotal>','<tax>','<totalPrice>' with '8'% tax rate
    And User clicks Finish Button and validate 'message' for purchase

    Examples:
      | productName                       | firstName | lastName   | zipCode | itemTotal | tax  | totalPrice |
      | Sauce Labs Backpack               | Ahmet     | Balbir     | 12010   | 29.99     | 2.40 | 32.39      |
      | Sauce Labs Bike Light             | Sonbul    | Kurt       | 11002   | 9.99      |      |            |
      | Sauce Labs Bolt T-Shirt           | Aigul     | Akylova    | 10010   | 15.99     |      |            |
      | Sauce Labs Fleece Jacket          | Sally     | My         | 12001   | 49.99     |      |            |
      | Sauce Labs Onesie                 | Micheal   | Easy       | 60543   | 7.99      |      |            |
      | Test.allTheThings() T-Shirt (Red) | Dice      | Washington | 32100   | 15.99     |      |            |
