package com.ssg.ioc;



import org.springframework.context.ApplicationContext;import org.springframework.context.annotation.AnnotationConfigApplicationContext;public class MainAnno {

  public static void main(String[] args) {
    ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    GreetingController controller = ctx.getBean(GreetingController.class);
    controller.handleRequest(); // "Hello, World!"
  }

//    public static void main(String[] args) {
//        runWhich(args);
//    }
//
//    static void runWhich(String[] args) {
//
//    }
//
//    static void runAnno() {
//
//    }
//
//    static void runBean() {
//
//    }
//
//    static void runXml() {
//
//}
}