package za.co.yoyowallet.kyc.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.co.yoyowallet.kyc.domain.Customer;
import za.co.yoyowallet.kyc.utils.messages.CommonResponse;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created  26/04/2021
 * Project  kyc
 * Author   Evans K F C
 **/
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Disabled
public class CustomerIntegrationUnitTest {


    private TestRestTemplate testRestTemplate;

    private Customer customer;

    @BeforeEach
    public void setup(){

        testRestTemplate = new TestRestTemplate();
        customer = new Customer();
        customer.setName("Evans");
        customer.setSurname("Chikuni");
        customer.setEmail("echikuni@gmail.com");
    }

    @Test
    public void createCustomerShouldReturnSuccess() throws Exception{
        final String baseUrl = "http://localhost:9099/api/customer/create";
        ResponseEntity<CommonResponse> response = testRestTemplate.
                exchange(baseUrl, HttpMethod.POST, new HttpEntity<>(customer,httpHeaders()),CommonResponse.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getNarrative()).isEqualTo("account created");
        assertThat(response.getBody().isSuccess()).isEqualTo(true);
    }

    private HttpHeaders httpHeaders(){
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_TYPE,MediaType.APPLICATION_JSON_VALUE);
        return httpHeaders;
    }
}
