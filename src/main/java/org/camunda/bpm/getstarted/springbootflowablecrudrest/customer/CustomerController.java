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

    @PutMapping("/")
    public CustomerDto updateCustomer(@RequestBody CustomerDto customerDto) {

        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping("/")
    public String deleteCustomer(@RequestParam Long id) {
        customerService.deleteCustomer(id);
        return "deleted";
    }

    @GetMapping("/findAll")
    public List<CustomerDto> findAll() {
        return customerService.findAll();
    }

}
