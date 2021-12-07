package com.switchfully.order.api.mapper;

import com.switchfully.order.domain.customer.Customer;
import com.switchfully.order.domain.customer.CustomerDto;

public class CustomerMapper {


    public CustomerDto mapCustomerToCustomerDto(Customer customer) {
        return new CustomerDto()
                .setCustomerId(customer.getCustomerId())
                .changeFirstName(customer.getFirstName())
                .changeLastName(customer.getLastName())
                .changeAddress(customer.getAddress())
                .changeEmailAddress(customer.getEmailAdress())
                .changePhoneNumber(customer.getPhoneNumber());
    }

    public Customer mapCustomerDtoToCustomer(CustomerDto customerDto) {
        return new Customer(customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getEmailAddress(),
                customerDto.getAddress(),
                customerDto.getPhoneNumber());

    }
}
