package com.ssg.springboard.controller;

import com.ssg.springboard.domain.SampleDTO;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Log4j2
@RequestMapping(value = "/sample")
public class SampleController {
  // url : /basic get 방식으로 요청 구현 "basic 요청" 로그 메시지 구현

  @GetMapping("/basic")
  public void basic() {
    log.info("basic 요청");
  }

  // 2. url: /ex1 get 방식으로 name 과 age를 전달하여 전달받은 name과 age 로그 메시지로 출력
  // 조건 : 파라미터 age 기본 값 20으로 설정
  @GetMapping("/ex1")
  public void ex1(@RequestParam("name") String name,
      @RequestParam(value = "age", required = false, defaultValue = "20") int age)
  {

    log.info("name: " + name);
    log.info("age: " + age);

  }

  // 3. url: /ex02Bean SampleDTOList 받아서 해당 list 로그 출력
  @GetMapping("/ex02Bean")
  public void ex02Bean(List<SampleDTO> sampleDTOList) {
    log.info(sampleDTOList);

  }







}
