package com.example.conductor.api.restAssured;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.hamcrest.core.IsEqual.equalTo;


public class RestAssuredTest {

    private ResponseSpecBuilder success = new ResponseSpecBuilder();
    private ResponseSpecBuilder notFound = new ResponseSpecBuilder();

    @Before
    public void setup(){
        success.expectStatusCode(200);
        notFound.expectStatusCode(404);
    }

    @Test
    public void testSuccessWhenGetAllClients(){
        RestAssured.given()
                        .when()
                        .get("/api/cliente")
                        .then()
                        .spec(success.build()); // substitui o statusCode(200)
    }

    @Test
    public void testSuccesswhenFindNeil(){
        RestAssured.given()
                    .when()
                    .get("/api/cliente/{id}", 1)
                    .then()
                    .log()
                    .ifValidationFails()
                    .statusCode(200)
                    .body("nome", equalTo("neil"));


    }

    @Test
    public void creatingClientWithStatusOK() {
        HashMap<String, String> cliente = new HashMap<>();
        cliente.put("nome", "João");
        cliente.put("email", "joabo@joao.com");
        cliente.put("senha", "123");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(cliente).when().post("/api/cliente")
                .then().spec(success.build());
    }

    @Test
    public void deletingClientWithStatusOk(){
        RestAssured.given()
                .when()
                .delete("/api/cliente/{id}", 11)
                .then().spec(success.build());
    }

    @Test
    public void updatingClientWithStatusOk(){
        HashMap<String, String> cliente = new HashMap<>();
        cliente.put("nome", "Editado");
        cliente.put("email", "editado@editado.com");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(cliente)
                .when().put("/api/cliente/{id}", 1)
                .then().spec(success.build());
    }
}
