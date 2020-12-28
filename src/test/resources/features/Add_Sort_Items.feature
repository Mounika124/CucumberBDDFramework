@Amazon
Feature: Add items to wish list and sort items

  Background: User is on  amazon home page
    Given User is on home page

  @AddItemToWishList
  Scenario Outline: Add an item to wish list
    When User search for an item with "<productName>"
    Then Verify the product name
    And Add the product to wish list
    Given Login in to the application
      | UserName   | Password     |
      | 8500336470 | MOUNIKAMINTU |
    Then Verify The WishList
    Examples:
      | productName |
      | Samsung     |

  @SortItems
  Scenario Outline: Sort items by applying filters
    When User search for an item with "<productName>"
    Then Sort items by applying filters
    Examples:
      | productName |
      | Samsung     |
      | OnePlus     |

