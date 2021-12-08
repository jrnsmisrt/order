package com.switchfully.order.service;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.UserLevel;
import com.switchfully.order.repository.ItemRepository;
import com.switchfully.order.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final Logger userServiceLogger= LoggerFactory.getLogger(UserService.class);


    @Autowired
    public UserService(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;

    }

    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }

    public List<User> viewAllCustomers() {
        userServiceLogger.info("view All Customers has been executed");
        return userRepository.showAllCustomers();
    }

    public User viewOneCustomer(String userId) {
        userServiceLogger.info("view One Customer id: "+userId+" has been executed");
        return userRepository.getCustomerById(userId);
    }

    public void createCustomerAccount(User user) {
        userServiceLogger.info("A new Customer account has been created id: "+ user.getUserId());
        user.changeUserLevel(UserLevel.CUSTOMER);
        userRepository.addUser(user);
    }


}
