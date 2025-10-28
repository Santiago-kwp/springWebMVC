//package com.ssg.membertest;
//
//import com.ssg.membertest.domain.MemberVO;
//import com.ssg.membertest.repository.MemberDAO;
//import java.util.List;
//import lombok.extern.log4j.Log4j2;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j2
//public class TestCodesJDBC {
//
//  @Autowired
//  private MemberDAO dao;
//
//  @Test
//  public void daoRepositoryTest() {
//
//    int result = dao.insert(
//        MemberVO.builder()
//            .mid("testID1")
//            .mpw("1234")
//            .mname("테스트아이디01")
//            .build()
//    );
//
//    if (result > 0) log.info("맴버 생성 성공");
//    else log.info("맴버 생성 실패!");
//
//  }
//
//  @Test
//  public void daoFindAllTest() {
//    List<MemberVO> voList = dao.findAll();
//
//    voList.forEach(log::info);
//
//  }
//
//
//}
