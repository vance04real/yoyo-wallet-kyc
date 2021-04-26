package za.co.yoyowallet.kyc.api;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.json.JacksonTester;
import za.co.yoyowallet.kyc.domain.Customer;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created  26/04/2021 - 10:51
 * Project  kyc
 * Author   Evans K F C
 **/
public class CustomerJsonunitTest {
    @Autowired
    private JacksonTester<Customer> customerJacksonTester;
    private Customer customer;

    @Before
    public void setup(){
        customer = new Customer();
        customer.setName("Evans");
        customer.setSurname("Chikuni");
        customer.setSurname("echikuni@gmail.com");

    }


    @Test
    public void givenCustomerWhenSerializeThenReturnCustomerJson() throws Exception {
        assertThat(customerJacksonTester.write(customer)).hasJsonPathStringValue("@.name");
        assertThat(customerJacksonTester.write(customer)).hasJsonPathStringValue("@.surname");
        assertThat(customerJacksonTester.write(customer)).hasJsonPathNumberValue("@.email");
        assertThat(customerJacksonTester.write(customer)).
                extractingJsonPathStringValue("@.name").isEqualTo("Evans");
        assertThat(customerJacksonTester.write(customer)).
                extractingJsonPathStringValue("@.surname").isEqualTo("Chikuni");
        assertThat(customerJacksonTester.write(customer)).
                extractingJsonPathStringValue("@.email").isEqualTo("echikuni@gmail.com");
    }

    @Test
    public void givenCustomerWhenDeserializeThenReturnCustomerObject() throws Exception {
        final String content = "{\"name\":\"Evans\",\"surname\":\"Chikuni\",\"email\":\"echikuni@gmail.com\"}";
        assertThat(customerJacksonTester.parse(content).getObject().toString()).isEqualTo(customer.toString());
        assertThat(customerJacksonTester.parseObject(content).getName()).isEqualTo(customer.getName());
        assertThat(customerJacksonTester.parseObject(content).getSurname()).isEqualTo(customer.getSurname());
        assertThat(customerJacksonTester.parseObject(content).getEmail()).isEqualTo(customer.getEmail());
    }
}
