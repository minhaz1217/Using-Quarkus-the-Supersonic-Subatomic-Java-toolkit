package com.minhazul;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTest {
    @Test
    void shouldGetAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .when()
                .get("/api/books")
                .then()
                .statusCode(200)
                .body("size()", is(4));
    }

    @Test
    void shouldGetBookCount() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
                .when()
                .get("/api/books/count")
                .then()
                .statusCode(200)
                .body(is("4"));
    }

    @Test
    void shouldGetBook() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParams("id", 2)
                .when()
                .get("/api/books/{id}")
                .then()
                .statusCode(200)
                .body("title", is("Test Book 2"))
                .body("id", is(2));
    }

}