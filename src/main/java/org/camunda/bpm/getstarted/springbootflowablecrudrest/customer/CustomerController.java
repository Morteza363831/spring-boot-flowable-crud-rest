package org.camunda.bpm.getstarted.springbootflowablecrudrest.customer;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/")
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto) {

        return customerService.createCustomer(customerDto);
    }

    @GetMapping("/{id}")
    public CustomerDto findCustomer(@PathVariable Long id) {
        return customerService.findCustomer(id);
    }

    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable Long id,
                                      @RequestBody CustomerDto customerDto) {

        return customerService.updateCustomer(id,customerDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
    }

    @GetMapping("/")
    public List<CustomerDto> findAll() {
        return customerService.findAll();
    }

}
