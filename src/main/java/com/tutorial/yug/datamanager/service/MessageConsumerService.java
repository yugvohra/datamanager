package com.tutorial.yug.datamanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tutorial.yug.datamanager.model.KafkaFacebookMessage;
import com.tutorial.yug.datamanager.persistence.entity.FaceBookMessage;
import com.tutorial.yug.datamanager.persistence.entity.FacebookMessagesDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Slf4j
public class MessageConsumerService {

  private final ObjectMapper mapper;
  private final FacebookMessagesDao fcbMessageDao;

  @Autowired
  public MessageConsumerService(ObjectMapper mapper, FacebookMessagesDao fcbMessageDao) {
    this.mapper = mapper;
    this.fcbMessageDao = fcbMessageDao;
  }

  @KafkaListener(topics = "${app.topic.fcb}")
  public void receiveMessage(@Payload String message) throws IOException {
    log.info("received message " + message);
    KafkaFacebookMessage kafkaFacebookMessage =mapper.readValue(message,KafkaFacebookMessage.class);
    fcbMessageDao.save(FaceBookMessage.fromKafkaMessage(kafkaFacebookMessage));

  }

}