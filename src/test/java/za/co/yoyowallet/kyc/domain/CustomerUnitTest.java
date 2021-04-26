package za.co.yoyowallet.kyc.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created  26/04/2021
 * Project  kyc
 * Author   Evans K F C
 **/
public class CustomerUnitTest {
    private Customer customer;

    @Before
    public void setup(){
        customer = new Customer();
        customer.setName("Evans");
        customer.setSurname("Chikuni");
        customer.setEmail("echikuni@gmail.com");
    }

    @Test
    public void givenCustomerWhenCreatingCustomerThenReturnCustomer(){
        assertNotNull(customer);
        assertEquals("name","Evans",customer.getName());
        assertEquals("surname","Chikuni",customer.getSurname());
        assertEquals("echikuni@gmail.com",customer.getSurname(),0);
    }
}
