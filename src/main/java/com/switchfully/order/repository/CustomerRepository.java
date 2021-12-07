package com.switchfully.order.repository;
import com.switchfully.order.domain.customer.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerRepository {
    private List<Customer> listOfCustomers;

    public List<Customer> showListOfCustomers(){
        return listOfCustomers;
    }

    public void addCustomer(Customer customer){
        listOfCustomers.add(customer);
    }

    public Customer getCustomerFromListOfCustomer(String id){
        for(Customer customer : listOfCustomers){
            if((customer.getCustomerId().toString()).equals(id)){
                return customer;
            }
        }
            return null;
    }


}
