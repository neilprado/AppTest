package com.example.conductor.api.restAssured;

import io.restassured.RestAssured;
import org.junit.Test;

import java.util.HashMap;

public class LoginTest {

    @Test
    public void successfulLogin(){
        HashMap<String, String> cliente = new HashMap<>();
        cliente.put("email", "neil@neil.com");
        cliente.put("senha", "123");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(cliente).when().post("/api/cliente/login")
                .then().statusCode(200);

    }

    @Test
    public void incorrectPassword(){
        HashMap<String, String> cliente = new HashMap<>();
        cliente.put("email", "neil@neil.com");
        cliente.put("senha", "123456");

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(cliente).when().post("/api/cliente/login")
                .then().statusCode(401);
    }

//    @Test
//    public void wrongEmail(){
//        HashMap<String, String > cliente = new HashMap<>();
//        cliente.put("email", "errado@errado.com");
//        cliente.put("senha", "123");
//
//        RestAssured.given()
//                .header("Content-Type", "application/json")
//                .body(cliente).when().post("/api/cliente/login")
//                .then().statusCode(404);
//    }

}
