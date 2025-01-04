
@tag
Feature: Submitting a Quote

 Background:
 Given i landed on eccommerce Page

  @SubmitOrder
  Scenario Outline: Positive Test of Submitting Order
    Given i logged in with username <username> and password <password>
    When i add product to Cart
    And click on Cart Button
    And click on checkout button
    And provide Shiping information and click on Place Order button
    Then validate that productname is being displayed
    
    
    
    Examples:
        |username        |password|
        |test@testold.com|Test@123|
