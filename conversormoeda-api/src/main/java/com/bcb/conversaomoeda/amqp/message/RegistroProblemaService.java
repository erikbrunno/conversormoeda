package com.bcb.conversaomoeda.amqp.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bcb.conversaomoeda.amqp.config.ProblemAMQPConfig;

@Service
public class RegistroProblemaService {

	private static final Logger log = LoggerFactory.getLogger(RegistroProblemaService.class);

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void enviarMessagem(ProblemaMensagem problemMessage) {
		log.info("Enviando mensagem");
		rabbitTemplate.convertAndSend(ProblemAMQPConfig.EXCHANGE_NAME, ProblemAMQPConfig.ROUTING_KEY, problemMessage);
		log.info("Mensagem enviada com sucesso");
	}
}
