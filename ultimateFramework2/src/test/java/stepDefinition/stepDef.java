package stepDefinition;

import static io.restassured.RestAssured.given;

import org.testng.Assert;

import apiResources.ApiDataBuilds;
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
	ResponseSpecification resSpec=responseSpecification();
	RequestSpecification reqSpec=requestSpecification();
	RequestSpecification req;
	public String finalResponse;

	ApiDataBuilds apb = new ApiDataBuilds();

	@Given("Add place Payload")
	public void add_place_payload() {
		
		

		req = given().spec(reqSpec).log().all().body(apb.addPlacePayload());

	}

	@When("User Calls {string} with Post http request")
	public void user_calls_with_post_http_request(String string) {

		res = req.when().post("/maps/api/place/add/json").then().spec(resSpec).extract().response();

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

	}

}
