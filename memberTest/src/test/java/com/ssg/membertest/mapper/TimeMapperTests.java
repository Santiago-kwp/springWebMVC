package com.ssg.membertest.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class TimeMapperTests {

  // 인터페이스이기 때문에 실제 주입은 불가능
  @Autowired(required = false)
  private TimeMapper2 timeMapper;

  @Test
  public void testTimeMapper() {
    log.info(timeMapper.getNow());
  }



}
