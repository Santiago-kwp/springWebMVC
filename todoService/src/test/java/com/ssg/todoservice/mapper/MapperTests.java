package com.ssg.todoservice.mapper;


import com.ssg.todoservice.domain.TodoVO;
import com.ssg.todoservice.dto.PageRequestDTO;
import java.time.LocalDate;
import java.util.List;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class MapperTests {

  // 인터페이스이기 때문에 실제 주입은 불가능
  @Autowired(required = false)
  private TodoMapper todoMapper;


  @Test
  public void testGetTime() {
    log.info(todoMapper.getTime());
  }

  @Test
  public void testInsertTodo() {
    todoMapper.insert(
        TodoVO.builder()
            .title("test02")
            .dueDate(LocalDate.now())
            .writer("tester01")
            .build()
    );
  }



  @Test
  public void testFindById() {
    log.info(todoMapper.findById(1L));
  }




}
