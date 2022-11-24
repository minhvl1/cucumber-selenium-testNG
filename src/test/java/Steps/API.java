package Steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


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

    }

}
