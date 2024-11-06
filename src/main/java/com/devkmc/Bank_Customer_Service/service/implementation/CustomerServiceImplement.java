package com.devkmc.Bank_Customer_Service.service.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devkmc.Bank_Customer_Service.Repository.CustomerRepository;
import com.devkmc.Bank_Customer_Service.entity.Customer;
import com.devkmc.Bank_Customer_Service.service.CustomerService;

@Service
@Transactional
public class CustomerServiceImplement implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Customer createCustomer(Customer customer) {
        try {
            // 비밀번호 암호화
            String encodedPassword = passwordEncoder.encode(customer.getPassword());
            customer.setPassword(encodedPassword);

            System.out.println("암호화된 비밀번호: " + encodedPassword);  // 암호화된 비밀번호 확인

            // 고객 정보 저장
            Customer savedCustomer = customerRepository.save(customer);

            // 저장된 고객 정보 출력
            System.out.println("저장된 고객 정보: " + savedCustomer);

            return savedCustomer;
        } catch (Exception e) {
            System.err.println("회원가입 실패: " + e.getMessage());
            throw e;  // 예외 발생 시 예외 던지기
        }
    }

    @Override
    public Customer getCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        return customer.orElseThrow(() -> new RuntimeException("Customer not found with ID: " + id));
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        Customer existingCustomer = getCustomerById(id);
        existingCustomer.setUsername(updatedCustomer.getUsername());
        existingCustomer.setEmail(updatedCustomer.getEmail());
        existingCustomer.setPhone(updatedCustomer.getPhone());

        // 비밀번호 변경시 암호화 후 저장
        if (updatedCustomer.getPassword() != null && !updatedCustomer.getPassword().isEmpty()) {
            existingCustomer.setPassword(passwordEncoder.encode(updatedCustomer.getPassword()));
        }

        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
