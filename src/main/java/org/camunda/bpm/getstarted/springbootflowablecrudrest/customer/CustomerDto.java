package org.camunda.bpm.getstarted.springbootflowablecrudrest.customer;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Long id;

    private String name;

    private boolean active;

    private String country;

    private String yearlyFee;
}
