package org.camunda.bpm.getstarted.springbootflowablecrudrest.customer;

import java.util.List;

public interface CustomerService {


    CustomerDto createCustomer(CustomerDto customerDto);

    CustomerDto findCustomer(Long id);

    CustomerDto updateCustomer(CustomerDto customerDto);

    void deleteCustomer(Long id);

    List<CustomerDto> findAll();

}
