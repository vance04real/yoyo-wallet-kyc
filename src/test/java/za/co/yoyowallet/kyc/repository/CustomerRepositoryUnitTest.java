package za.co.yoyowallet.kyc.repository;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import za.co.yoyowallet.kyc.domain.Customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created  26/04/2021
 * Project  kyc
 * Author   Evans K F C
 **/

@DataJpaTest
public class CustomerRepositoryUnitTest {
    private Customer customer;
    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void setup(){
        customer = new Customer();
        customer.setName("mal");
        customer.setSurname("3rn");
        customer.setEmail("echikuni@gmail.com");
    }

    @Test
    public void givenCustomerWhenCreatingCustomerThenReturnCustomer(){
        assertNotNull(customer);
        final Customer savedCustomer = customerRepository.save(customer);
        assertNotNull(savedCustomer.getId());
        assertEquals("name",customer.getName(),savedCustomer.getName());
        assertEquals("surname",customer.getSurname(),savedCustomer.getSurname());
        assertEquals(customer.getEmail(),savedCustomer.getEmail(),0);
    }
}
