package com.ssg.springwebmvc.sample;

import com.ssg.springwebmvc.prof.LectureRoom;
import java.sql.Connection;
import javax.sql.DataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import lombok.extern.log4j.Log4j2;

@ExtendWith(SpringExtension.class) // JUnit 버전에서 Spring-test를 사용하기 위한 설정 어노테이셔
// 스프링의 설정 정보를 로딩하기 위한
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class SampleTests {


  // spring container한테 쓰려고 요청함 (xml에 등록하는 순간 제어권은 스프링에게 넘어감 => 개발자는 요청해서 써야됨)
  // @Autowired => Spring 에서 사용하는 의존성 주입 어노테이션
  @Autowired
  private SampleService sampleService;
  // 만일 지정된 빈이 존재한다면 이곳에 주입해 주기를 원해요

  @Autowired
  private Restaurant restaurant;

  @Autowired
  private LectureRoom lectureRoom;

  @Autowired
  private DataSource dataSource;

  // 스프링은 필요한 객체를 스프링에 주입해 주기 때문에 개념적으로 클래스를 작성해서 빈을 통해 등록해 두기만 하면,
  // 원하는  곳에서 쉽게 다른 객체를 사용할 수 있다.
  @Test
  public void TestDataSource() throws Exception {
    Connection connection = dataSource.getConnection();
    log.info(connection);
    Assertions.assertNotNull(connection);
    connection.close();
  }



  @Test
  public void testLectureRoom() {
    log.info(lectureRoom);
    Assertions.assertNotNull(lectureRoom);
  }

  @Test
  public void testSampleService() {
    log.info(sampleService);
    Assertions.assertNotNull(sampleService);

  }

  @Test
  public void testRestaurant() {
    log.info(restaurant);
    Assertions.assertNotNull(restaurant);
  }


}
