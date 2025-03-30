package com.satyamagrawal.bookstore.orderservice.web.controllers;

import com.satyamagrawal.bookstore.orderservice.AbstractIT;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import com.satyamagrawal.bookstore.orderservice.testdata.TestDataFactory;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class OrderControllerTests extends AbstractIT {

    @Nested
    class CreateOrderTests  {
        @Test
        void shouldCreateOrderSuccessfully() {
            var payload =
                    """
                            {
                                "customer": {
                                    "name":"Satyam",
                                    "email":"abcd@gmail.com",
                                    "phone": "123457890"
                                },
                                "deliveryAddress": {
                                    "addressLine1": "adr1",
                                    "addressLine2": "adr2",
                                    "city": "c1",
                                    "state":"s1",
                                    "zipCode":"123456",
                                    "country":"In"
                                },
                                "items": [
                                    {
                                        "code": "P100",
                                        "name": "Product 1",
                                        "price": 25.50,
                                        "quantity": 1
                            
                                    }
                                ]
                            }
                            
                            """;

            given().contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post("/api/orders")
                    .then()
                    .statusCode(HttpStatus.CREATED.value())
                    .body("orderNumber", notNullValue());
        }

        @Test
        void shouldReturnBadRequestWhenMandatoryDataIsMissing() {
            var payload = TestDataFactory.createOrderRequestWithInvalidCustomer();
            given().contentType(ContentType.JSON)
                    .body(payload)
                    .when()
                    .post("/api/orders")
                    .then()
                    .statusCode(HttpStatus.BAD_REQUEST.value());

        }
    }
}
