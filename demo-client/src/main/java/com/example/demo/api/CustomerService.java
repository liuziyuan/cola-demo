package com.example.demo.api;

import com.alibaba.cola.dto.Response;
import com.example.demo.dto.CustomerAddCmd;

public interface CustomerService {
    Response addCustomer(CustomerAddCmd cmd);
}
