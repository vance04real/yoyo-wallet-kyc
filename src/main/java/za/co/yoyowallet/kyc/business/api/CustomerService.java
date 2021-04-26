package za.co.yoyowallet.kyc.business.api;

import org.springframework.data.domain.Pageable;
import za.co.yoyowallet.kyc.utils.messages.CommonResponse;
import za.co.yoyowallet.kyc.utils.Dtos.CustomerDto;
import za.co.yoyowallet.kyc.utils.messages.CustomerResponse;



/**
 * Created  25/04/2021
 * Project  kyc
 * Author   Evans K F C
 **/
public interface CustomerService {

    CommonResponse createCustomer(CustomerDto customerDto);
    CustomerResponse getAllCustomer(Pageable pageable);
}
