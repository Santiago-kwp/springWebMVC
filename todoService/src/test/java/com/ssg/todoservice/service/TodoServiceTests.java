package com.ssg.todoservice.service;

import com.ssg.todoservice.dto.PageRequestDTO;
import com.ssg.todoservice.dto.PageResponseDTO;
import com.ssg.todoservice.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class TodoServiceTests {

  @Autowired(required = false)
  private TodoService todoService;


  @Test
  public void testPaging() {
    PageRequestDTO pageRequestDTO = PageRequestDTO.builder().page(100).size(10).build();
    PageResponseDTO<TodoDTO> responseDTO =
        todoService.getList(pageRequestDTO);
    log.info(responseDTO);
    responseDTO.getDtoList().forEach(log::info);

  }



}
