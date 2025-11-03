package com.ssg.springboard.controller;

import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/replys")
public class ReplyController {

  // String 이지만 json 형태로 주고 싶어! => produces = MediaType.APPLICATION_JSON_VALUE ;
  //consumes 도 있음.
  @GetMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
  public String sample() {

//    return Map.of("value1", "AAAA", "value2", "BBBB"); => json 방식으로 전달됨.
    return "Hello RestController";
  }

}
