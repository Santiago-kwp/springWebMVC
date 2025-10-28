package com.ssg.membertest.mapper;

import com.ssg.membertest.domain.MemberVO;
import lombok.extern.log4j.Log4j2;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class MemberMapperTests {

  // 인터페이스이기 때문에 실제 주입은 불가능
  @Autowired(required = false)
  private MemberMapper memberMapper;

  @Test
  public void testInsertMember() {
    MemberVO vo = MemberVO.builder()
            .mid("MapperID1")
                .mpw("1234")
                    .mname("mapperID1")
                        .build();
    memberMapper.insert(vo);
  }

  @Test
  public void testSelectMember() {
    List<MemberVO> voList= memberMapper.findAll();
    voList.forEach(log::info);

  }

}
