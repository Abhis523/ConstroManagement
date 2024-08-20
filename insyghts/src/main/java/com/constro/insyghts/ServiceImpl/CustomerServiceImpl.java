package com.constro.insyghts.ServiceImpl;

import com.constro.insyghts.Assembller.CustomerAssembler;
import com.constro.insyghts.Dto.CustomerDto;
import com.constro.insyghts.Entity.Customer;
import com.constro.insyghts.Repository.CustomerRepository;
import com.constro.insyghts.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

    @Service
    public class CustomerServiceImpl implements CustomerService {

        @Autowired
        private CustomerRepository customerRepository;

        @Autowired
        private CustomerAssembler customerAssembler;

        @Override
        public CustomerDto getCustomerById(Long id) {
            Customer customer = customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
            return customerAssembler.toDto(customer);
        }

        @Override
        public CustomerDto createCustomer(CustomerDto customerDto) {
            Customer customer = customerAssembler.toEntity(customerDto);
            customer = customerRepository.save(customer);
            return customerAssembler.toDto(customer);
        }

        @Override
        public void deleteCustomer(Long id) {
            customerRepository.deleteById(id);
        }
    }
