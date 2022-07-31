
Feature: Validating Place Api

  Scenario: Verify is Place is being Successfully Added
    Given Add place Payload with "<name>", "<language>", "<address>"
    When User Calls "AddPlaceApi" with "Post" http request
    Then the API call is success with Status code 200
    And "status" in response body is "OK"

    Examples: 
      | name  		| language  | address  |
      | LanAaroon | English 	| London	 |
   #   | Lan	  		| Tamil 		| Chennai  |

	Scenario: View the added Place
		Given Get the added place
		When User Calls "GetPlaceApi" with "Get" http request
		Then the API call is success with Status code 200
		And "name" in response body is "<name>"
		
    Examples: 
      | name  		| language  | address  |
      | LanAaroon | English 	| London	 |
    #  | Lan	  		| Tamil 		| Chennai  |