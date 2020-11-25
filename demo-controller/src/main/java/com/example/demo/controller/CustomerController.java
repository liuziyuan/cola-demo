package com.example.demo.controller;

import com.alibaba.cola.dto.Response;
import com.example.demo.api.CustomerService;
import com.example.demo.dto.CustomerAddCmd;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api
@Slf4j
@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {
    @Resource
    private CustomerService customerService;

    @PostMapping(value = "/")
    public Response addCustomer(@RequestBody CustomerAddCmd customerAddCmd){
        return customerService.addCustomer(customerAddCmd);
    }
}
