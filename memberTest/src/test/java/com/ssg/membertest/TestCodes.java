//package com.ssg.membertest;
//
//import com.ssg.membertest.dao.MemberDAO;
//import com.ssg.membertest.domain.MemberVO;
//import com.ssg.membertest.dto.MemberDTO;
//import com.ssg.membertest.service.MemberService;
//import java.util.List;
//import java.sql.Connection;
//import javax.sql.DataSource;
//import lombok.extern.log4j.Log4j2;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
//@Log4j2
//public class TestCodes {
//
//  @Autowired
//  private DataSource dataSource;
//
//  @Autowired
//  private MemberDAO dao;
//
//  @Autowired
//  private MemberService service;
//
//  @Test
//  public void TestDataSource() throws Exception {
//    Connection connection = dataSource.getConnection();
//    log.info(connection);
//    Assertions.assertNotNull(connection);
//    connection.close();
//  }
//
//  @Test
//  public void TestInsertDAO() throws Exception {
//    MemberVO vo = MemberVO.builder()
//        .mid("TestId")
//        .mpw("1234")
//        .mname("이름테스트")
//        .build();
//    int result = dao.insertMember(vo);
//    log.info(result);
//
//  }
//
//  @Test
//  public void TestSelectDAO() throws Exception {
//
//    List<MemberVO> voList = dao.selectMembers();
//    log.info(voList);
//
//  }
//
//  @Test
//  public void TestCreateService() throws Exception {
//    MemberDTO dto = MemberDTO.builder()
//        .mid("TestId222")
//        .mpw("1234")
//        .mname("이름테스트-서비스")
//        .build();
//    int result = service.createMember(dto);
//    log.info(result);
//
//  }
//
//  @Test
//  public void TestListService() throws Exception {
//    List<MemberDTO> dtoList = service.listMembers();
//    dtoList.forEach(log::info);
//    dtoList.forEach(System.out::println);
//
//  }
//
//
//
//
//}
