package com.switchfully.order.repository;

import com.switchfully.order.domain.customer.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerRepository {
    private List<Customer> listOfCustomers;

    public List<Customer> viewListOfCustomers() {
        return listOfCustomers;
    }

    public void addCustomer(Customer customer) {
        listOfCustomers.add(customer);
    }

    public void removeCustomer(String id) {

    }
}
