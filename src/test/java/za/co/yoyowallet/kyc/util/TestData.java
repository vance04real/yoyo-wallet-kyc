package za.co.yoyowallet.kyc.util;

import za.co.yoyowallet.kyc.domain.Customer;
import za.co.yoyowallet.kyc.utils.Dtos.CustomerDto;

import java.math.BigDecimal;

/**
 * Created  26/04/2021 - 11:20
 * Project  kyc
 * Author   Evans K F C
 **/
public class TestData {

    public static Customer getCustomer() {
        final Customer customer = new Customer();
        customer.setName("Evans");
        customer.setSurname("Chikuni");
        customer.setEmail("echikuni@gmail.com");
        return customer;
    }

    public static CustomerDto getCustomerDto(){
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName("Evans");
        customerDto.setSurname("Chikuni");
        customerDto.setEmail("echikuni@gmail.com");
        return customerDto;
    }
}
