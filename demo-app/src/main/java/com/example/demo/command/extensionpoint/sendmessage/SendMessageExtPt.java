package com.example.demo.command.extensionpoint.sendmessage;

import com.alibaba.cola.extension.ExtensionPointI;
import com.example.demo.domain.aggregate.shortmessage.entity.SimpleTemplate;
import com.example.demo.dto.ShortMessageSendCmd;

public interface SendMessageExtPt extends ExtensionPointI {

    void sendMessageAfterSuccessfulOperation(ShortMessageSendCmd cmd);
}
