#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.api.clients;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import ${package}.api.models.UserRegistration;
import ${package}.properties.Environment;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserApiClient {

    private final String apiBaseUrl;
    private final Gson gson;
    private static final String REGISTER_ENDPOINT = "/users/register";

    public UserApiClient() {
        this.apiBaseUrl = Environment.getProperties().apiUrl();
        this.gson = new Gson();
    }

    public Response registerUser(UserRegistration user) {
        String requestBody = gson.toJson(user);
        return given()
                .baseUri(apiBaseUrl)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(requestBody)
                .log().all()
                .when()
                .post(REGISTER_ENDPOINT)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public Response registerUserAsJson(String jsonBody) {
        return given()
                .baseUri(apiBaseUrl)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonBody)
                .log().all()
                .when()
                .post(REGISTER_ENDPOINT)
                .then()
                .log().all()
                .extract()
                .response();
    }

    public boolean isRegistrationSuccessful(Response response) {
        int statusCode = response.getStatusCode();
        return statusCode == 200 || statusCode == 201;
    }

    public String getResponseBody(Response response) {
        return response.getBody().asString();
    }

    public Map getResponseAsMap(Response response) {
        return response.as(Map.class);
    }
}
