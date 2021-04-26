package za.co.yoyowallet.kyc.business.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import za.co.yoyowallet.kyc.business.api.CustomerService;
import za.co.yoyowallet.kyc.domain.Customer;
import za.co.yoyowallet.kyc.repository.CustomerRepository;
import za.co.yoyowallet.kyc.utils.messages.CommonResponse;
import za.co.yoyowallet.kyc.utils.Dtos.CustomerDto;
import za.co.yoyowallet.kyc.utils.exceptions.CustomerException;
import za.co.yoyowallet.kyc.utils.messages.CustomerResponse;

import java.util.List;
import java.util.stream.Collectors;

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
    public CommonResponse createCustomer(CustomerDto customerDto) {
        final CommonResponse response = new CommonResponse();
        if(customerDto == null){
            response.setNarrative("Account Not created ");
            return response;
        }

        Customer customer = convertCustomerDtoToCustomer(customerDto);
        customerRepository.save(customer);
        response.setNarrative("account created");
        response.setSuccess(true);
        return response;
    }

    @Override
    public CustomerResponse getAllCustomer(Pageable pageable) {
        CustomerResponse response =  new CustomerResponse();
        Page<Customer> customerPageList = customerRepository.findAll(pageable);
        if(customerPageList.getContent().isEmpty()){
          response.setNarrative("No results Found");
          return response;
        }

        response.setList(customerPageList.getContent().stream().map(this::convertCustomer).collect(Collectors.toList()));
        response.setTotalPages((long) customerPageList.getTotalPages());
        response.setSuccess(true);
        response.setNarrative("Successfully Retrieved all Customer");
        return response;
    }

    private CustomerDto convertCustomer(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setName(customer.getName());
        customerDto.setSurname(customer.getSurname());
        customerDto.setEmail(customer.getEmail());
        return customerDto;
    }

    private Customer convertCustomerDtoToCustomer(CustomerDto customerDto){
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setEmail(customerDto.getEmail());
        return customer;

    }


}
