@Amazon
Feature: Pincode change and prime benefits and cart verification


  @PinCode
  Scenario: Add PinCode To The Address
    Given User is on home page
    When User select location by entering pincode
      | pinCode |
      | 500081  |
    Then Verify the pincode is added or not
    And Search The Product
      | productName |
      | Samsung     |
    Then Verify Options in Product Page
