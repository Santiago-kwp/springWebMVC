package com.ssg.ioc;


public class GreetingController {
  private final MessageService messageService;

  // 생성자 주입
  public GreetingController(MessageService messageService) {
    this.messageService = messageService;
  }

  public void handleRequest() {
    System.out.println(messageService.makeGreeting());
  }
   
}
