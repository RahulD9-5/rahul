
@tag
Feature: Error Validation Test.


  Background:
  Given i landed on eccommerce Page

  @LoginErrorValidationtest
  Scenario Outline: Positive Test of Submitting Order
    Given i logged in with username <username> and password <password>
    Then validate that "Incorrect email or password." error is received
    
    
    Examples:
        |username        |password|
        |test@testold.com|Test@1234|
