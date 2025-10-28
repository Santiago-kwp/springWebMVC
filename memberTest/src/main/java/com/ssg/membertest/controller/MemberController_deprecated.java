//package com.ssg.membertest.controller;
//
//import com.ssg.membertest.dto.MemberDTO;
//import com.ssg.membertest.service.MemberService;
//import java.sql.SQLException;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping("/members")
//@RequiredArgsConstructor
//@Log4j2
//public class MemberController_deprecated {
//
//  private final MemberService memberService;
//
//  @GetMapping("/list")
//  public void list(Model model) {
//    log.info("Member List Controller");
//    try {
//      model.addAttribute("members",memberService.listMembers());
//    } catch (SQLException e) {
//      throw new RuntimeException(e);
//    }
//
//  }
//
//  @GetMapping("/register")
//  public void registerForm() {
//    log.info("Member Register GET Controller");
//  }
//
//  @PostMapping("/register")
//  public String register(MemberDTO memberDTO) {
//    log.info("Member Register POST Controller");
//    try {
//      int result = memberService.createMember(memberDTO);
//      if (result > 0) {
//        log.info("멤버 생성 성공!");
//
//      } else {
//        log.info("멤버 생성 성공!");
//      }
//    } catch (SQLException e) {
//      throw new RuntimeException(e);
//    }
//    return "redirect:/member/list"; // 등록 후 목록 페이지로 리디렉션
//
//  }
//
//
//
//
//}
