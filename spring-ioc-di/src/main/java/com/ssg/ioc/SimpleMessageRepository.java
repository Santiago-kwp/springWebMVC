package com.ssg.ioc;




public class SimpleMessageRepository implements MessageRepository {
  @Override
  public String findGreetingTarget() {
    return "World";
  }
   
}
