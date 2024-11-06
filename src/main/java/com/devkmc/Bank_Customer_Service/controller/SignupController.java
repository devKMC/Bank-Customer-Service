package com.devkmc.Bank_Customer_Service.controller;

import com.devkmc.Bank_Customer_Service.entity.Customer;
import com.devkmc.Bank_Customer_Service.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/signup") // 회원가입을 위한 엔드포인트
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class SignupController {

    @Autowired
    private CustomerService customerService;

    // POST 요청을 통해 회원가입 처리
    @PostMapping
    public ResponseEntity<String> signup(@RequestBody Customer customer) {
        try {
            // 회원가입 처리
            Customer savedCustomer = customerService.createCustomer(customer);

            // 회원가입 성공 메시지
            return new ResponseEntity<>("회원가입 성공! 저장된 고객 정보: " + savedCustomer, HttpStatus.CREATED);
        } catch (Exception e) {
            // 예외 발생 시 실패 메시지
            System.err.println("회원가입 실패: " + e.getMessage());
            return new ResponseEntity<>("회원가입 실패: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
