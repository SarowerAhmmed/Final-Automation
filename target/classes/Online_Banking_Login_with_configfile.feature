@Smoke @Functional @Regression
Feature: Login function test
Description: 	Users can successfully login with valid credentials


  @Positive @Negative @TC_QB4N_38 @TC_QB4N_39
  Scenario Outline: As a Smattech online banking user, login should success with valid credential but failed with invalid credencial
    Given Open browser
    And Go to application
    When Put user "<User>"
    And Put pass "<Pass>"
    And Click login button
    Then Validate login

    Examples: 
      | User    			| Pass 						|
      | VALID_USER 		| VALID_PASS 			| 
      | VALID_USER		| INVALID_PASS		| 
      | INVALID_USER	| VALID_PASS			|
      | INVALID_USER	| INVALID_PASS		|
      | NULL_USER			| NULL_PASS				|
      | VALID_USER		| NULL_PASS				|
      | NULL_USER			| VALID_PASS			|
      
