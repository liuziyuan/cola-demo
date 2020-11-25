package com.example.demo.dto.clientobject;

import com.alibaba.cola.dto.ClientObject;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public abstract class AbstractCustomerCO extends ClientObject {

    private Long id;
}
