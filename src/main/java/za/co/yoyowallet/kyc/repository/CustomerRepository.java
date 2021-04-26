package za.co.yoyowallet.kyc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.yoyowallet.kyc.domain.Customer;

/**
 * Created  25/04/2021
 * Project  kyc
 * Author   Evans K F C
 **/
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
