package com.ssg.ioc;

import org.springframework.context.ApplicationContext;import org.springframework.context.annotation.AnnotationConfigApplicationContext;public class MainBean {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigManual.class);
    GreetingController controller = ctx.getBean(GreetingController.class);
    controller.handleRequest();
  }

}
