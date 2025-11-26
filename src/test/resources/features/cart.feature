Feature: Cart

  Background: Navigate to nopCommerce Home Page
    Given I am on Home page
    And I am a guest user

    @test1
    Scenario: Verify product is added to cart
#      Given I click on "Phones" category
      When I select "HTC One M9" product
      Then I expect to navigate to "HTC One M9" product details page
      When I click on Add to cart button
      Then I expect to see "Product added" alert
      And I accept the alert
      When I click on "Cart" header link
      Then I expect to navigate to cart page
      And I expect to see "HTC One M9" product is added to cart