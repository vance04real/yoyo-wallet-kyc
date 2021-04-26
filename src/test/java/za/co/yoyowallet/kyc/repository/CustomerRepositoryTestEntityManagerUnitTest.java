package za.co.yoyowallet.kyc.repository;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import za.co.yoyowallet.kyc.domain.Customer;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created  26/04/2021
 * Project  kyc
 * Author   Evans K F C
 **/

@DataJpaTest
public class CustomerRepositoryTestEntityManagerUnitTest {
    private Customer customer;
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TestEntityManager testEntityManager;

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
        testEntityManager.persistAndFlush(customer);
        final Optional<Customer> returnedCustomer = customerRepository.findById(1L);
        assertNotNull(returnedCustomer.get().getId());
        assertEquals("name",customer.getName(),returnedCustomer.get().getName());
        assertEquals("surname",customer.getSurname(),returnedCustomer.get().getSurname());
        assertEquals(customer.getEmail(),returnedCustomer.get().getEmail(),0);
    }

}
