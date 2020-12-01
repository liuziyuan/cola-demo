package com.example.demo.command;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.example.demo.command.extensionpoint.sendmessage.SendMessageExtPt;
import com.example.demo.common.bizdefinition.BizCode;
import com.example.demo.common.bizdefinition.ScenarioCode;
import com.example.demo.common.bizdefinition.UseCaseCode;
import com.example.demo.domain.aggregate.account.entity.Account;
import com.example.demo.domain.gateway.AccountGateway;
import com.example.demo.domain.seedwork.BaseOperationType;
import com.example.demo.dto.DrawMoneyCmd;
import com.example.demo.dto.ShortMessageSendCmd;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class DrawMoneyCmdExe {
    @Resource
    private AccountGateway accountGateway;

    // 扩展实现可以按照具体场景放在App Service, Execute, Domain Service, Domain中完成，具体看场景与业务。
    // 从当前样例的合理性上，建议将扩展点写到Service中，保持DrawMoneyCmdExe只处理DrawMoney本身的业务。
    // 如果需求上强制的DrawMoney过程中必须实现发短信功能，而不是一种扩展的概念，那么可以选择将扩展点写下本类。
    @Resource
    private ExtensionExecutor extensionExecutor;

    public Response execute(DrawMoneyCmd cmd) {
        Account account = accountGateway.getAccountByAccountNo(cmd.getTransactionCO().getAccountNo());
        account.setBaseInfo(cmd.getOperater(), BaseOperationType.UPDATE);
        account.drawMoney(cmd.getTransactionCO().getAmount());
        accountGateway.save(account);
        ShortMessageSendCmd smsc = new ShortMessageSendCmd(account.getCustomer().getIdInfo().getName(), cmd.getTransactionCO().getAccountNo(), UseCaseCode.ACCOUNT_CREATE, cmd.getTransactionCO().getAmount());
        extensionExecutor.executeVoid(
                SendMessageExtPt.class,
                BizScenario.valueOf(BizCode.PERSONAL_BANKING_BUSINESS, UseCaseCode.ACCOUNT_DRAW, ScenarioCode.SEND_SHORT_MESSAGE),
                extension -> extension.sendMessageAfterSuccessfulOperation(smsc));
        return Response.buildSuccess();
    }

}
