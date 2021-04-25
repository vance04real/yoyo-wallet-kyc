package za.co.yoyowallet.kyc.api.customer;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import za.co.yoyowallet.kyc.business.api.CustomerService;
import za.co.yoyowallet.kyc.domain.Customer;
import za.co.yoyowallet.kyc.utils.CommonResponse;

/**
 * Created  25/04/2021 - 23:15
 * Project  kyc
 * Author   Evans K F C
 **/

@CrossOrigin
@RestController
@RequestMapping("api/customer/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("create")
    @ApiOperation(value = "Creating a Customer endpoint",response = CommonResponse.class)
    public CommonResponse createAccount(@RequestBody Customer customer){
        return customerService.createCustomer(customer);
    }
}
