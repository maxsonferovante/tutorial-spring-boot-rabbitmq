package com.masterdev.demo.worker.producer;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoSucessoProdutor {
    private final AmqpTemplate amqpTemplate;

    public PagamentoSucessoProdutor(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    public void gerarResposta(String mensagem){
        amqpTemplate.convertAndSend(
            "pagamento-response-sucesso-exchange",
            "pagamento-response-sucesso-rout-key",
            mensagem);
    }
}
