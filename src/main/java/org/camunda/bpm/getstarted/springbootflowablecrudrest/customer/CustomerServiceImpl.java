package org.camunda.bpm.getstarted.springbootflowablecrudrest.customer;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               ModelMapper modelMapper) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto customerDto) {

        System.out.println(customerDto.getCountry() + " " + customerDto.getName() + " " + customerDto.isActive());
        CustomerEntity customer = modelMapper.map(customerDto , CustomerEntity.class);
        customerRepository.save(customer);
        return modelMapper.map(customer,CustomerDto.class);
    }

    @Override
    public CustomerDto findCustomer(Long id) {

        Optional<CustomerEntity> customerOpt = customerRepository.findById(id);
        if (!customerOpt.isPresent()) return null;
        CustomerEntity customer = customerOpt.get();
        return modelMapper.map(customer,CustomerDto.class);
    }

    @Override
    public CustomerDto updateCustomer(CustomerDto customerDto) {

        System.out.println("asd;jfasd");
        Optional<CustomerEntity> customerOpt = customerRepository.findById(customerDto.getId());
        if (!customerOpt.isPresent()) return null;
        CustomerEntity customer = customerOpt.get();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setActive(customerDto.isActive());
        customer.setCountry(customerDto.getCountry());
        customer.setYearlyFee(customerDto.getYearlyFee());
        System.out.println(customerDto.getId() + " " + customerDto.getCountry() + " " + customerDto.getName() + " " + customerDto.isActive() + " " + customerDto.getYearlyFee() + " hi");

        customerRepository.save(customer);
        return modelMapper.map(customer,CustomerDto.class);
    }

    @Override
    public void deleteCustomer(Long id) {

        customerRepository.deleteById(id);
    }

    @Override
    public List<CustomerDto> findAll() {
        List<CustomerDto> customerDtoList = new ArrayList<>();
        for (CustomerEntity customer: customerRepository.findAll()) {
            customerDtoList.add(modelMapper.map(customer,CustomerDto.class));
        }
        System.out.println("finished");
        return customerDtoList;
    }
}
