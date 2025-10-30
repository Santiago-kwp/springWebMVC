package com.ssg.ioc;

import org.springframework.context.ApplicationContext;import org.springframework.context.support.ClassPathXmlApplicationContext;public class MainXML {

  public static void main(String[] args) {
    ApplicationContext ctx =
        new ClassPathXmlApplicationContext("applicationContext.xml"); // 스프링 컨테이너를 구성

    GreetingController controller = ctx.getBean("greetingController", GreetingController.class);
    controller.handleRequest(); //   → "Hello, World!"
  }

}
