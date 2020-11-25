package com.example.demo.service;

import com.alibaba.cola.dto.Response;
import com.example.demo.api.CustomerService;
import com.example.demo.command.CustomerAddCmdExe;
import com.example.demo.dto.CustomerAddCmd;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    private CustomerAddCmdExe customerAddCmdExe;

    @Override
    public Response addCustomer(CustomerAddCmd cmd) {
        return customerAddCmdExe.execute(cmd);
    }
}
