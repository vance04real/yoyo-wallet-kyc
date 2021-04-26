package za.co.yoyowallet.kyc.business.impl;

import za.co.yoyowallet.kyc.business.api.CustomerService;
import za.co.yoyowallet.kyc.domain.Customer;
import za.co.yoyowallet.kyc.repository.CustomerRepository;
import za.co.yoyowallet.kyc.utils.CommonResponse;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created  25/04/2021 - 22:51
 * Project  kyc
 * Author   Evans K F C
 **/
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CommonResponse createCustomer(Customer customer) {
        final CommonResponse response = new CommonResponse();
        final Customer savedCustomer = customerRepository.save(customer);
        response.setNarrative("account created");
        response.setSuccess(true);
        return response;
    }

    @Override
    public Supplier<CommonResponse> getAllCustomer() {
        Supplier<CommonResponse> response =  CommonResponse::new;
        response.get().setList(customerRepository.findAll());
        response.get().setSuccess(true);
        response.get().setNarrative("Successfully Retrieved all Customer");
        return response;
    }

}
