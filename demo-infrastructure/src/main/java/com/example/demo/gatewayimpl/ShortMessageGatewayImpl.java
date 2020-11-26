package com.example.demo.gatewayimpl;

import com.example.demo.domain.aggregate.shortmessage.entity.SimpleTemplate;
import com.example.demo.domain.gateway.ShortMessageGateWay;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ShortMessageGatewayImpl implements ShortMessageGateWay {

    @Override
    public void sendShortMessage(String message) {
        //模拟发短信
        log.info(message);
    }
}
