package com.ssg.todoservice.service;

import com.ssg.todoservice.dto.TodoDTO;
import java.util.List;

public interface TodoService {

  void register(TodoDTO dto);

  List<TodoDTO> listTodos();

  TodoDTO getOneTodo(Long tno);

}
