package com.switchfully.order.service;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.repository.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode=DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)

public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Test
    void whenCreatingNewCustomerAccount_AssureCustomerIsAddedToRepository(){
        User testUser = new User("TestUser","testUser", "@@@", "ttt", "000");
        userService.createCustomerAccount(testUser);
        Assertions.assertThat(userRepository.showAllUsers()).contains(testUser);
    }

    //other methods have been tested with postman

}
