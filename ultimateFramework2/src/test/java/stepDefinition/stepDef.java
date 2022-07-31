package stepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import apiResources.ApiDataBuilds;
import apiResources.ApiResourceConstants;
import apiResources.apiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDef extends apiUtils {
	Response res;
	ResponseSpecification resSpec = responseSpecification();
	RequestSpecification reqSpec = requestSpecification();
	RequestSpecification req;
	static String placeId;
	public String finalResponse;
	ApiResourceConstants resourceApi;

	ApiDataBuilds apb = new ApiDataBuilds();

	@Given("Add place Payload with {string}, {string}, {string}")
	public void add_place_payload_with(String name, String language, String address) {

		req = given().spec(reqSpec).log().all().body(apb.addPlacePayload(name, language, address));

	}

	@When("User Calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String apiMethod) {

		resourceApi = ApiResourceConstants.valueOf(resource);

		if (apiMethod.equalsIgnoreCase("Post")) {
			res = req.when().post(resourceApi.getResourceApi()).then().spec(resSpec).extract().response();
		}

		else if (apiMethod.equalsIgnoreCase("Get")) {
			res = req.when().get(resourceApi.getResourceApi()).then().spec(resSpec).extract().response();
		}

		finalResponse = res.asString();

		System.out.println(finalResponse);

	}

	@Then("the API call is success with Status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		Assert.assertEquals(res.getStatusCode(), 200);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {

		JsonPath js = new JsonPath(finalResponse);
		Assert.assertEquals(js.get(key).toString(), value);
		placeId = js.getString("place_id");
		System.out.println(placeId);
	}
	
	@Given("Get the added place")
	public void get_the_added_place() {
		System.out.println("Getting the added Place");
		req = given().spec(reqSpec).log().all().queryParam("place_id",placeId );
	}
	

}
