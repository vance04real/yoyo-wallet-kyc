package za.co.yoyowallet.kyc.api.customer;

import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import za.co.yoyowallet.kyc.business.api.CustomerService;
import za.co.yoyowallet.kyc.utils.messages.CommonResponse;
import za.co.yoyowallet.kyc.utils.Dtos.CustomerDto;
import za.co.yoyowallet.kyc.utils.messages.CustomerResponse;

/**
 * Created  25/04/2021
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
    public CommonResponse createCustomer(@RequestBody CustomerDto customerDto){
        return customerService.createCustomer(customerDto);
    }

    @GetMapping(value ="all",  params = {"page", "size","sort"})
    @ApiOperation(value = "Creating a Customer endpoint",response = CommonResponse.class)
    public CustomerResponse findAllCustomer(@RequestParam(value = "page", defaultValue = "0") int page,
                                            @RequestParam(value = "size", defaultValue = "10") int size,
                                            @RequestParam(value = "sort", defaultValue = "id") String sort){
        Pageable pageable = PageRequest.of(page,size,Sort.by(sort));
        return customerService.getAllCustomer(pageable);
    }
}


