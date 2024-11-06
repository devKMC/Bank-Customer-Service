package com.devkmc.Bank_Customer_Service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devkmc.Bank_Customer_Service.entity.Customer;

@Service
public interface CustomerService {
	Customer createCustomer(Customer customer); // 고객 생성
	Customer getCustomerById(Long id); // ID로 고객 조회
	List<Customer> getAllCustomers(); // 모든 고객 조회
	Customer updateCustomer(Long id, Customer customer); // 고객 정보 업데이트
	void deleteCustomer(Long id); // 고객 삭제
}