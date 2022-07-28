
Feature: Validating Place Api

  Scenario: Verify is Place is being Successfully Added
    Given Add place Payload
    When User Calls "AddPlaceApi" with Post http request
    Then the API call is success with Status code 200
    And "status" in response body is "OK"


