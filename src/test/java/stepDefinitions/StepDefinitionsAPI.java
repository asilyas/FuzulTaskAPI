package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static baseUrl.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class StepDefinitionsAPI {

    Response response;

    @Given("Send GET request for Entity")
    public void send_get_request_for_entity() {

        spec.pathParam("pr1", "Entity");

        response = given(spec).when().get("{pr1}");

    }

    @Then("Verifies that status code is equal to {int}")
    public void verifies_that_status_code_is_equal_to(Integer int1) {

        response.then().assertThat().statusCode(int1);

    }

    @Then("Verifies that data with id number {int} exists")
    public void verifies_that_data_with_id_number_exists(Integer id) {

        response.then().assertThat().body("data.id", hasItem(id));

    }

    @Then("Verifies that the data.value contains {string}")
    public void verifies_that_the_data_value_contains(String satilik) {
        response.then().assertThat().body("data.value", hasItems(satilik));

    }

    @Given("Send a GET request for EntityGroup")
    public void send_a_get_request_for_entity_group() {
        spec.pathParam("pr1", "EntityGroup");

        response = given(spec).when().get("{pr1}");

    }

    @Then("Verifies that data with id number {int} {int} {int} exists")
    public void verifies_that_data_with_id_number_exists(Integer id1, Integer id2, Integer id3) {
        response.then().assertThat().body("data.id", hasItems(id1, id2, id3));


    }

    @Then("Verifies that the Emlak tipi contains {string} {string} {string}")
    public void verifies_that_the_emlak_tipi_contains(String str1, String str2, String str3) {

        int dataSize = response.jsonPath().getList("data").size();
        for (int i = 0; i < dataSize; i++) {
            if (response.jsonPath().getString("data.value[" + i + "]").equals("Emlak Tipi")) {
                response.then().assertThat().body("data.entity[" + i + "].value", hasItems(str1, str2, str3));

            }
        }
    }

    @Then("User verifies that the Oda Sayisi contains {string}")
    public void userVerifiesThatTheOdaSayisiContains(String oda) {

        int dataSize = response.jsonPath().getList("data").size();
        for (int i = 0; i < dataSize; i++) {
            if (response.jsonPath().getString("data.value[" + i + "]").equals("Oda Sayısı")) {
                response.
                        then().
                        assertThat().
                        body("data.entity[" + i + "].value", hasItem(oda));
            }
        }
    }


    @Given("Sends a GET request for Product")
    public void sendsAGETRequestForProduct() {
        spec.pathParam("pr1", "Product");

        response = given(spec).
                when().
                get("{pr1}");
    }


    @Then("Verifies that pageSize is equal to {int}")
    public void verifiesThatPageSizeIsEqualTo(int pageSize) {
        int actualPageNumber = response.jsonPath().get("pageSize");
        assertEquals(pageSize, actualPageNumber);

    }


    @Then("Verifies that apiResultType is equal to {int}")
    public void verifiesThatApiResultTypeIsEqualTo(int apiResultType) {
        int actualapiResultType = response.jsonPath().get("apiResultType");
        assertEquals(apiResultType, actualapiResultType);

    }

    @Then("Verifies that the data contains {int} values")
    public void verifiesThatTheDataContainsValues(int dataCo) {
        response.
                then().
                assertThat().
                body("data", hasSize(dataCo));
    }
}