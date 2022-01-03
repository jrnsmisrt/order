package com.switchfully.order.service;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.UserLevel;
import com.switchfully.order.repository.ItemRepository;
import com.switchfully.order.repository.UserRepository;
import com.switchfully.order.security.exceptions.CustomerDoesNotExistException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final Logger userServiceLogger = LoggerFactory.getLogger(UserService.class);


    @Autowired
    public UserService(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;

    }

    public User getUserById(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) throw new CustomerDoesNotExistException("customer not found");
        else {
            return optionalUser.get();
        }
    }

    public List<User> viewAllCustomers() {
        userServiceLogger.info("view All Customers has been executed");
        return userRepository.findAll();
    }

    public User viewOneCustomer(long userId) {
        userServiceLogger.info("view One Customer id: " + userId + " has been executed");
        if(userRepository.findById(userId).isEmpty()){
            throw new CustomerDoesNotExistException("customer not found");
        }else return userRepository.findById(userId).get();
    }

    public void createCustomerAccount(User user) {
        userServiceLogger.info("A new Customer account has been created id: " + user.getUserId());
        user.changeUserLevel(UserLevel.CUSTOMER);
        userRepository.save(user);
    }


}
