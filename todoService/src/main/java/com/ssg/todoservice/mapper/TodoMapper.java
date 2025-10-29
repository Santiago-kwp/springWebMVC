package com.ssg.todoservice.mapper;

import com.ssg.todoservice.domain.TodoVO;
import java.util.List;
public interface TodoMapper {
  String getTime();

  void insert(TodoVO todoVO);
  List<TodoVO> findAll();
  TodoVO findById(Long tno);


}
