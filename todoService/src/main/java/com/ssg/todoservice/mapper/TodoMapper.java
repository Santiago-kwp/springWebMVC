package com.ssg.todoservice.mapper;

import com.ssg.todoservice.domain.TodoVO;
import com.ssg.todoservice.dto.PageRequestDTO;
import java.util.List;
public interface TodoMapper {
  String getTime();
  void insert(TodoVO todoVO);
  List<TodoVO> findAll(PageRequestDTO pageRequestDTO);
  List<TodoVO> findList(PageRequestDTO pageRequestDTO);

  TodoVO findById(Long tno);
  void delete(Long tno);
  void update(TodoVO todoVO);

  int getCount(PageRequestDTO pageRequestDTO);
}
