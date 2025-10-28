package com.ssg.membertest.controller;

import com.ssg.membertest.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {

  @RequestMapping("/list")
  public void list() {
    log.info("TODO List Controller");
  }

  //@GetMapping("/register") 아래랑 같은 의미임.
  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public void register() {
    log.info("TodoController Register method!");
  }

  @PostMapping("/register") // Spring 4버전 부터 추가됨. 그 전에는 RequestMapping으로 활용함.
  public void registerPost(TodoDTO todoDTO) {
    log.info("Post TODO Register~~");
    log.info(todoDTO);
  }






}
