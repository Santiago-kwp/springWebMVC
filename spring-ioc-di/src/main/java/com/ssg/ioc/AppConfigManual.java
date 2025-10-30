package com.ssg.ioc;

import org.springframework.context.annotation.Bean;import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigManual {

  @Bean
  public MessageRepository messageRepository() {
    return new SimpleMessageRepository();
  }

  @Bean
  public MessageService messageService(MessageRepository messageRepository) {
    return new GreetingMessageService(messageRepository);
  }

  @Bean
  public GreetingController greetingController(MessageService messageService) {
    return new GreetingController(messageService);
  }

    
}
