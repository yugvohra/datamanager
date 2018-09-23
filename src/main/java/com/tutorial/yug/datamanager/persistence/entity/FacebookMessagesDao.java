package com.tutorial.yug.datamanager.persistence.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vohray on 6/27/18.
 */
@Repository
public interface FacebookMessagesDao extends CrudRepository<FaceBookMessage,Long> {

}
