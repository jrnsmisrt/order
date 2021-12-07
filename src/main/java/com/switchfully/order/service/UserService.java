package com.switchfully.order.service;

import com.switchfully.order.domain.user.User;
import com.switchfully.order.domain.user.UserLevel;
import com.switchfully.order.repository.ItemRepository;
import com.switchfully.order.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;


    @Autowired
    public UserService(UserRepository userRepository, ItemRepository itemRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;

    }

    public User getUserById(String id) {
        return userRepository.getUserById(id);
    }

    public List<User> viewAllCustomers() {
        return userRepository.showAllCustomers();
    }

    public User viewOneCustomer(String userId) {
        return userRepository.getCustomerById(userId);
    }

    public void createCustomerAccount(User user) {
        user.changeUserLevel(UserLevel.CUSTOMER);
        userRepository.addUser(user);
    }


}
