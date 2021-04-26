package za.co.yoyowallet.kyc.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import za.co.yoyowallet.kyc.business.api.CustomerService;
import za.co.yoyowallet.kyc.business.impl.CustomerServiceImpl;
import za.co.yoyowallet.kyc.repository.CustomerRepository;

/**
 * Created  25/04/2021 - 22:39
 * Project  kyc
 * Author   Evans K F C
 **/

@Configuration
@EnableJpaRepositories(basePackages = {"za.co.yoyowallet.kyc.repository"})
@EntityScan(basePackages = {"za.co.yoyowallet.kyc.domain"})
public class BusinessConfig {

    @Bean
    public CustomerService customerService(final CustomerRepository customerRepository){
        return new CustomerServiceImpl(customerRepository);
    }
}
