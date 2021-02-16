Feature:my location

  @myLocation
  Scenario: User on the home page
    Given the user go to home page
    When the user click on the input box
    When the user click on the my location button
    And the user click sale search button
    Then Verify "SORRY, NO PROPERTIES FOUND" message displayed
  @BT6ForSale
  Scenario: Search "BT6" postcode for sale
    Given the user go to home page
    When the user click on the input box
    And the user enters "BT6"
    Then the user click sale search button
    Then Verify all postcodes are "BT6"
  @BT6ForRent
  Scenario: Search "BT6" postcode for rent
    Given the user go to home page
    When the user click on the input box
    And the user enters "BT6"
    Then the user clicks rent
    Then Verify all postcodes are "BT6" in the rent page

  @G31NoProperties
  Scenario: "G31" postcodeWhere results has no properties
    Given the user go to home page
    When the user click on the input box
    And the user enters "G31"
    And the user click sale search button
    Then Verify "SORRY, NO PROPERTIES FOUND" message displayed
