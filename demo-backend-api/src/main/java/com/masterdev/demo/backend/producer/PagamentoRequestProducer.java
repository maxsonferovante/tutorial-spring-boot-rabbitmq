package com.masterdev.demo.backend.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.masterdev.demo.backend.dto.PagamentoDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRequestProducer {
    private final AmqpTemplate amqpTemplate;

    private final ObjectMapper objectMapper = new ObjectMapper();

    public PagamentoRequestProducer(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void integrar (PagamentoDTO pagamento) throws JsonProcessingException {
        amqpTemplate.convertAndSend(
            "pagamento-request-exchange",
            "pagamento-request-rout-key",
            objectMapper.writeValueAsString(pagamento)
        );
    }
}
