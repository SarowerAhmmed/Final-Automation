@Smoke @Functional @Regression
Feature: Login function test
Description: 	Users can successfully login with valid credentials


  @Positive @Negative @TC_QB4N_38 @TC_QB4N_39
  Scenario Outline: As a Smattech online banking user, login should success with valid credential but failed with invalid credencial
    Given Open browser
    And Go to application
    When Put user "<User>" from Excel
    And Put pass "<Pass>" from Excel
    And Click login button
    Then Validate login

    Examples: 
      | User    			| Pass 						|
      | 1_0 					| 1_1 						| 
   		| 2_0 					| 2_1 						|  
    	| 3_0 					| 3_1 						| 
    	| 4_0 					| 4_1 						| 
    	| 5_0 					| 5_1 						| 
