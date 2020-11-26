package com.example.demo.command.extension.sendmessage;

import com.alibaba.cola.extension.Extension;
import com.example.demo.command.extensionpoint.sendmessage.SendMessageExtPt;
import com.example.demo.common.bizdefinition.BizCode;
import com.example.demo.common.bizdefinition.ScenarioCode;
import com.example.demo.common.bizdefinition.UseCaseCode;
import com.example.demo.domain.gateway.ShortMessageGateWay;
import com.example.demo.dto.ShortMessageSendCmd;

import javax.annotation.Resource;

@Extension(bizId = BizCode.PERSONAL_BANKING_BUSINESS, useCase = UseCaseCode.ACCOUNT_DRAW, scenario = ScenarioCode.SEND_SHORT_MESSAGE)
public class AccountDrawSucceedSendMessageExt implements SendMessageExtPt {

    @Resource
    private ShortMessageGateWay shortMessageGateWay;

    @Override
    public void sendMessageAfterSuccessfulOperation(ShortMessageSendCmd cmd) {
        //定制你扩展的业务代码
        String message = String.format("你好, %s: 你的账户 %s, 进行了%s操作, 金额%s.",
                cmd.getUsername(),
                cmd.getAccountNo(),
                UseCaseCode.ACCOUNT_CONSUME,
                cmd.getAmount());
        shortMessageGateWay.sendShortMessage(message);
    }
}
