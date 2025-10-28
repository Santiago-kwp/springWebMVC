package com.ssg.membertest.controller;

import com.ssg.membertest.dto.TodoDTO;
import java.time.LocalDate;
import jdk.internal.icu.text.NormalizerBase.Mode;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // 해당 클래스가 스프링MVC에서 컨트롤러 역할을 한다. 스프링의 빈으로 등록
@Log4j2
public class SampleController {

  // doGet 메소드로 등록해서 url pattern 등록
  @GetMapping("/hello")
  public void hello() {
    log.info("hello spring webmvc!");
  }

  @GetMapping("/ex01")
  public void ex01(String name, int age) {
    log.info("ex01에서 수집한 파라미터");
    log.info("name: " + name);
    log.info("age: " + age);
  }

  @GetMapping("/ex02")
  public void ex02(@RequestParam(name="name", defaultValue = "lalala") String name,
      @RequestParam(name = "age", defaultValue = "10") int age) {
    log.info("ex02에서 수집한 파라미터");
    log.info("name: " + name);
    log.info("age: " + age);
  }

  @GetMapping("/ex03")
  public void ex03(LocalDate dueDate) {
    log.info("ex03에서 수집한 파라미터");
    log.info("dueDate: " + dueDate);
  }

  @GetMapping("/ex04")
  public void ex04(Model model) {
    log.info("ex04 Model 파라미터");
    model.addAttribute("message", "Hello Spring MVC");
  }

  @GetMapping("/ex04_1")
  public void ex04_1(TodoDTO todoDTO, Model model) {
    log.info(todoDTO);
    model.addAttribute("todoDTO",todoDTO);
  }





}
