package com.constro.insyghts.Assembller;

import com.constro.insyghts.Dto.CustomerDto;
import com.constro.insyghts.Entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerAssembler {

    public CustomerDto toDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }

    public Customer toEntity(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        // Set other fields if needed
        return customer;
    }
}
