package com.example.demo.command.extension.sendmessage;

import com.alibaba.cola.extension.Extension;
import com.example.demo.command.extensionpoint.sendmessage.SendMessageExtPt;
import com.example.demo.common.bizdefinition.BizCode;
import com.example.demo.common.bizdefinition.ScenarioCode;
import com.example.demo.common.bizdefinition.UseCaseCode;
import com.example.demo.domain.gateway.ShortMessageGateWay;
import com.example.demo.dto.ShortMessageSendCmd;

import javax.annotation.Resource;

@Extension(bizId = BizCode.PERSONAL_BANKING_BUSINESS, useCase = UseCaseCode.CUSTOMER_CREATE, scenario = ScenarioCode.SEND_SHORT_MESSAGE)
public class CustomerCreatedSendMessageExt implements SendMessageExtPt {

    @Resource
    private ShortMessageGateWay shortMessageGateWay;

    @Override
    public void sendMessageAfterSuccessfulOperation(ShortMessageSendCmd cmd) {
        //定制你扩展的业务代码
        String message = String.format("你好, %s: 你已经成功加入COLA FRAMEWORK",
                cmd.getUsername());
        shortMessageGateWay.sendShortMessage(message);
    }
}
