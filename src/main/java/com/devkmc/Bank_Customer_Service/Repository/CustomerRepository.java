package com.devkmc.Bank_Customer_Service.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.devkmc.Bank_Customer_Service.entity.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
