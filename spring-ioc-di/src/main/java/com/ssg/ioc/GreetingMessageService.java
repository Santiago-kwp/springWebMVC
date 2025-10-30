package com.ssg.ioc;




public class GreetingMessageService implements MessageService {
  private final MessageRepository messageRepository;

  // 생성자 주입
  public GreetingMessageService(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @Override
  public String makeGreeting() {
    return "Hello, " + messageRepository.findGreetingTarget() + "!";
  }
   
}
