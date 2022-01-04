package com.switchfully.order.service;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.repository.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import io.restassured.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Before
    public void setup() {
        RestAssured.baseURI = "localhost";
        RestAssured.port = 8080;
    }

    @Test
    void whenCreatingNewCustomerAccount_AssureCustomerIsAddedToRepository() {
        User testUser = new User("TestUser", "testUser", "@@@", "ttt", "000");
        userService.createCustomerAccount(testUser);
        Assertions.assertThat(userRepository.findAll()).contains(testUser);
    }

  /*  @Test
    void whenRequestGETCustomers_ThenReturnStatusCodeOK() {
        //FYI only works when application runs.
        RestAssured.when().request(("GET"), ("/users")).then().statusCode(200);
    }
*/
    //other methods have been tested with postman



}
