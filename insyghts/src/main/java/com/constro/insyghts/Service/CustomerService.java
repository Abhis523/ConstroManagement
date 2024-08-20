package com.constro.insyghts.Service;

import com.constro.insyghts.Dto.CustomerDto;

public interface CustomerService {
    CustomerDto getCustomerById(Long id);
    CustomerDto createCustomer(CustomerDto customerDTO);
    void deleteCustomer(Long id);
}
