package Steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.asserts.SoftAssert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;


public class API {
    List<String> getListResponse;
    Response getResponse;
    @When("send get method with id={string}")
    public void sendGetMethodWithId(String arg0) {
        RestAssured.baseURI = "https://fakerestapi.azurewebsites.net/api/v1/Activities";
        RequestSpecification httpRequest = RestAssured.given();
        getResponse = httpRequest.request(Method.GET, arg0);
        String responseBody = getResponse.getBody().asString();

        getListResponse = new ArrayList<String>(Arrays.asList(responseBody.split(",")));
    }

    @When("show get response body")
    public void showGetResponseBody() {
        System.out.println("==================Response==================");
        System.out.println("Status code:"+getResponse.getStatusCode());
        for(int i =0; i<getListResponse.size();i++){
            System.out.println(getListResponse.get(i));
        }
        System.out.println("==================End Response==================");
    }


    @Then("id contains {string}")
    public void idContains(String arg0) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(getListResponse.get(0).contains(arg0));
        softAssert.assertEquals(getResponse.getStatusCode(),"200");
    }


    //dont need get value api
    @Given("test")
    public void test() {

        String baseUri = "https://fakerestapi.azurewebsites.net/api/v1";

        // Request Scope
        RequestSpecification request = RestAssured.given();

        // add baseUri and basePath into the request
        request.baseUri(baseUri);
        request.basePath("/Activities");

        // Response scope
        final String FIRST_TODO = "/1";
        Response response = request.get(FIRST_TODO);
        response.prettyPrint();
        response.then().body("id", equalTo(1));
        response.then().body("title", equalTo("Activity 1"));
        response.then().body("completed", equalTo(false));
    }


    @Given("test post")
    public void testPost() {
        String baseUri = "https://reqres.in/api/users";

        // Request Scope
        RequestSpecification request = RestAssured.given();
        request.baseUri(baseUri);

        request.header(new Header("Content-type", "application/json; charset=UTF-8"));
        String requestBody = "{\n" +
                "    \"name\": \"morpheus\",\n" +
                "    \"job\": \"leader\"\n" +
                "}";
        Response response = request.body(requestBody).post("/posts");
        response.prettyPrint();
        response.then().body("name", equalTo("morpheus"));
        response.then().body("job", equalTo("leader"));
    }
}
