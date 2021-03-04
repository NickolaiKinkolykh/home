
Feature: Desktop Checkout for Guest User - Feature 2
  As a customer
  I want to be able proceed to checkout
  So that I can specify my delivery and payment details and place the order

  Scenario: Short Google test
    Given I am an anonymous customer with clear cookies
    And I open the direct URL "https://www.google.com/"
    And I type "something" into search input
