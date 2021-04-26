package za.co.yoyowallet.kyc.business;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import za.co.yoyowallet.kyc.business.api.CustomerService;
import za.co.yoyowallet.kyc.business.impl.CustomerServiceImpl;
import za.co.yoyowallet.kyc.domain.Customer;
import za.co.yoyowallet.kyc.repository.CustomerRepository;
import za.co.yoyowallet.kyc.utils.Dtos.CustomerDto;
import za.co.yoyowallet.kyc.utils.messages.CommonResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Created  26/04/2021
 * Project  kyc
 * Author   Evans K F C
 **/
public class CustomerServiceUnitTest {
    @Mock
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    private Customer customer;

    private CustomerDto customerDto;


    @Before
    public void setup(){
        customerService = new CustomerServiceImpl(customerRepository);
        customer = new Customer();
        customer.setName("Evans");
        customer.setSurname("Chikuni");
        customer.setEmail("echikuni@gmail.com");

        customerDto = new CustomerDto();
        customerDto.setName("Evans");
        customerDto.setSurname("Chikuni");
        customerDto.setEmail("echikuni@gmail.com");
    }


    @Test
    public void givenCustomerWhenCreatingCustomerThenReturnCustomer(){
        when(customerRepository.save(customer)).thenReturn(customer);
        final CommonResponse response  = customerService.createCustomer(customerDto);
        assertNotNull(response);
        assertEquals("narrative","account created",response.getNarrative());
        assertEquals("success",true,response.isSuccess());
    }
}
