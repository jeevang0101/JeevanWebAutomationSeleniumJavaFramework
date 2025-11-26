Feature: Home Page

  Background: Navigate to Demoblaze Home Page
    Given I am on Home page

  Rule: Guest user
      Background: User is on Demoblaze Home Page as guest user
                # background steps are applied to all scenarios under Guest user Rule
        Given I am a guest user

        @guestUser
        Scenario: Verify home page product categories
        When I am viewing home product category section
        Then I expect to see following product categories
          | Phones   |
          | Laptops  |
          | Monitors |