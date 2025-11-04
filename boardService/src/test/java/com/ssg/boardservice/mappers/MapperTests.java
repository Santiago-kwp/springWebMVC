package com.ssg.boardservice.mappers;


import com.ssg.boardservice.domain.BoardVO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class MapperTests {

  // 인터페이스이기 때문에 실제 주입은 불가능
  @Autowired(required = false)
  private BoardMapper boardMapper;


  @Test
  public void test1() {
    log.info(boardMapper);
  }

  @Test
  public void testInsertTodo() {

    log.info("Board Insert test!!");

    boardMapper.insert(
        BoardVO.builder()
            .title("첫 번째 게시글")
            .content("안녕하세요. 첫 게시글입니다.")
            .writer("홍길동")
            .password("pass1234")
            .build()
    );
  }

  @Test
  public void testFindAll() {
    boardMapper.getList().forEach(log::info);
  }

  @Test
  public void testFindById() {
    log.info(boardMapper.findById(1L));
  }

  @Test
  public void testUpdateTodo() {

    log.info("Board update test!!");

    boardMapper.update(
        BoardVO.builder()
            .bno(1L)
            .title("첫 번째 게시글 (수정)")
            .content("안녕하세요. 첫 게시글입니다.(수정)")
            .writer("홍길동")
            .password("pass1234")
            .build()
    );
  }


}
