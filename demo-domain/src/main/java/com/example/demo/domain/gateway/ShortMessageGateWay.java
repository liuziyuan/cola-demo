package com.example.demo.domain.gateway;

import com.example.demo.domain.aggregate.shortmessage.entity.SimpleTemplate;
import com.example.demo.domain.aggregate.shortmessage.repository.ShortMessageRepository;

public interface ShortMessageGateWay extends ShortMessageRepository {
    void sendShortMessage(String message);
}
