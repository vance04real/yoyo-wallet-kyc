package za.co.yoyowallet.kyc.business;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import za.co.yoyowallet.kyc.business.api.CustomerService;
import za.co.yoyowallet.kyc.business.impl.CustomerServiceImpl;
import za.co.yoyowallet.kyc.domain.Customer;
import za.co.yoyowallet.kyc.repository.CustomerRepository;
import za.co.yoyowallet.kyc.utils.Dtos.CustomerDto;
import za.co.yoyowallet.kyc.utils.messages.CommonResponse;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static za.co.yoyowallet.kyc.util.TestData.getCustomer;
import static za.co.yoyowallet.kyc.util.TestData.getCustomerDto;

/**
 * Created  26/04/2021
 * Project  kyc
 * Author   Evans K F C
 **/
public class CustomerServiceUnitTest {
    @Mock
    private CustomerRepository customerRepository;

    private CustomerService customerService;


    @BeforeEach
    public void setup(){
        customerRepository = mock(CustomerRepository.class);
        customerService = new CustomerServiceImpl(customerRepository);
    }


    @Test
    public void givenCustomerWhenCreatingCustomerThenReturnSuccessResponse(){
        when(customerRepository.save(any(Customer.class))).thenReturn(getCustomer());
        final CommonResponse response  = customerService.createCustomer(getCustomerDto());
        assertNotNull(response);
        assertEquals("narrative","account created",response.getNarrative());
        assertEquals("success",true,response.isSuccess());
        verify(customerRepository,times(1)).save(any(Customer.class));
    }

    @Test
    public void givenCustomerWhenCreatingCustomerThenReturnFailedResponse(){
        final CommonResponse response  = customerService.createCustomer(null);
        assertNotNull(response);
        assertEquals("narrative","Account Not created",response.getNarrative());
        assertEquals("success",false,response.isSuccess());

    }
}
