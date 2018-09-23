package com.tutorial.yug.datamanager.persistence.entity;

import com.tutorial.yug.datamanager.model.KafkaFacebookMessage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

/**
 * Created by vohray on 6/27/18.
 */
@Entity
@Table(name="facbook_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaceBookMessage {

  @Id
  private String id;

  private String message;

  private String userId;

  private String userName;

  private Date postDate;


  public static FaceBookMessage fromKafkaMessage(KafkaFacebookMessage kafkaFacebookMessage)
  {return new FaceBookMessage(UUID.randomUUID().toString(),kafkaFacebookMessage.getMessage(),kafkaFacebookMessage.getUserId(),kafkaFacebookMessage.getUserName(),kafkaFacebookMessage.getPostedDate());
  }

}
