package com.tutorial.yug.datamanager;

;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SuppressWarnings("squid:S1118")
@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableJpaRepositories
public class Application {
  /**
   * Main function for run server.
   *
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    System.out.println("testing deployment");

  }
}