package com.example.demo.command;

import com.alibaba.cola.dto.Response;
import com.example.demo.domain.aggregate.customer.entity.Customer;
import com.example.demo.domain.aggregate.customer.factory.CustomerFactory;
import com.example.demo.domain.gateway.CustomerGateway;
import com.example.demo.domain.seedwork.BaseOperationType;
import com.example.demo.dto.CustomerAddCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CustomerAddCmdExe {

    @Resource
    private CustomerGateway customerGateway;

    public Response execute(CustomerAddCmd cmd) {
        Customer customer = CustomerFactory.getCustomer();
        customer.getIdInfo().getAddress().setZipcode(cmd.getCustomerCO().getZipcode());
        customer.getIdInfo().getAddress().setStreet(cmd.getCustomerCO().getStreet());
        customer.getIdInfo().getAddress().setState(cmd.getCustomerCO().getState());
        customer.getIdInfo().getAddress().setCountry(cmd.getCustomerCO().getCountry());
        customer.getIdInfo().getAddress().setCity(cmd.getCustomerCO().getCity());
        customer.getIdInfo().setNation(cmd.getCustomerCO().getNation());
        customer.getIdInfo().setName(cmd.getCustomerCO().getName());
        customer.getIdInfo().setIdNumber(cmd.getCustomerCO().getIdNumber());
        customer.getIdInfo().setBirthday(cmd.getCustomerCO().getBirthday());
        customer.setTotalAmount(cmd.getCustomerCO().getTotalAmount());
        customer.setBaseInfo(cmd.getOperater(), BaseOperationType.SAVE);
        customerGateway.save(customer);
        return Response.buildSuccess();
    }
}
