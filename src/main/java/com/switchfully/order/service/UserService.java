package com.switchfully.order.service;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.item.Item;
import com.switchfully.order.repository.CustomerRepository;
import com.switchfully.order.repository.ItemRepository;
import com.switchfully.order.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;
    private final CustomerRepository customerRepository;

    @Autowired
    public UserService(UserRepository userRepository, ItemRepository itemRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
        this.customerRepository=customerRepository;
    }

    public void addItem(Item item){

        itemRepository.addItem(item);
    }

    public List<Customer> showAllCustomers(){
        return customerRepository.showListOfCustomers();
    }

    public Customer viewCustomer(String customerId){
        return customerRepository.getCustomerFromListOfCustomer(customerId);
    }

}
