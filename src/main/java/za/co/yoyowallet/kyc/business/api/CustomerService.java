package za.co.yoyowallet.kyc.business.api;

import za.co.yoyowallet.kyc.domain.Customer;
import za.co.yoyowallet.kyc.utils.CommonResponse;

import javax.websocket.server.PathParam;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created  25/04/2021 - 22:50
 * Project  kyc
 * Author   Evans K F C
 **/
public interface CustomerService {

    CommonResponse createCustomer(Customer customer);
    CommonResponse getAllCustomer();
}
