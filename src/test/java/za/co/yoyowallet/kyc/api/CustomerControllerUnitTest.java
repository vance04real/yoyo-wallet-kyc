package za.co.yoyowallet.kyc.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import za.co.yoyowallet.kyc.api.customer.CustomerController;
import za.co.yoyowallet.kyc.business.api.CustomerService;
import za.co.yoyowallet.kyc.domain.Customer;
import za.co.yoyowallet.kyc.utils.Dtos.CustomerDto;
import za.co.yoyowallet.kyc.utils.messages.CommonResponse;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static za.co.yoyowallet.kyc.util.TestData.getCustomerDto;

/**
 * Created  26/04/2021
 * Project  kyc
 * Author   Evans K F C
 **/

@WebMvcTest(CustomerController.class)
public class CustomerControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    private CommonResponse response;


    @BeforeEach
    public void setup(){
        response = new CommonResponse();
    }

    @Test
    @DisplayName("customer opening test")
    public void givenCustomerWhenCreatingCustomerThenReturnCustomer() throws Exception {
        response.setSuccess(true);
        response.setNarrative("account created");
        given(customerService.createCustomer(any(CustomerDto.class))).willReturn(response);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/customer/create").
                contentType(MediaType.APPLICATION_JSON_VALUE).
                content(objectMapper.writeValueAsString(getCustomerDto())))
                .andExpect(status().isOk()).
                andExpect(jsonPath("success").value(true)).
                andExpect(jsonPath("narrative").value("account created"));

    }

}
