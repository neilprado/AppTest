package com.example.conductor.api.restAssured;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.core.annotation.Order;

import java.util.HashMap;




public class RestAssuredTest {

    private ResponseSpecBuilder success = new ResponseSpecBuilder();
    private ResponseSpecBuilder notFound = new ResponseSpecBuilder();

    @Before
    public void setup(){
        success.expectStatusCode(200);
        notFound.expectStatusCode(404);
    }

    @Test
    @Order(2)
    public void testSuccessWhenGetAllClients(){
        RestAssured.given()
                        .when()
                        .get("/api/cliente")
                        .then()
                        .spec(success.build()); // substitui o statusCode(200)
    }

    @Test
    @Order(3)
    public void testSuccesswhenFindAClient(){
        RestAssured.given()
                    .when()
                    .get("/api/cliente/{id}", 1)
                    .then()
                    .log()
                    .ifValidationFails()
                    .statusCode(200)
                    .body("nome", CoreMatchers.equalTo("Neil"));


    }

    @Test
    @Order(1)
    public void creatingClientWithStatusOK() {
        HashMap<String, String> cliente = new HashMap<>();
        cliente.put("nome", "José");
        cliente.put("email", "jose@jose.com");
        cliente.put("senha", "123");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(cliente).when().post("/api/cliente")
                .then().spec(success.build());
    }

    @Test
    @Order(5)
    public void deletingClientWithStatusOk(){
        RestAssured.given()
                .when()
                .delete("/api/cliente/{id}", 4)
                .then().spec(success.build());
    }

    @Test
    @Order(4)
    public void updatingClientWithStatusOk(){
        HashMap<String, String> cliente = new HashMap<>();
        cliente.put("nome", "Editado");
        cliente.put("email", "editado@editado.com");
        cliente.put("senha", "12345");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(cliente)
                .when().put("/api/cliente/{id}", 5)
                .then().spec(success.build());
    }
}
