package com.ssg.todoservice.service;

import com.ssg.todoservice.domain.TodoVO;
import com.ssg.todoservice.dto.TodoDTO;
import com.ssg.todoservice.mapper.TodoMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoServiceImpl implements TodoService{

  private final TodoMapper todoMapper;
  private final ModelMapper modelMapper;

  @Override
  public void register(TodoDTO todoDTO) {
    log.info(modelMapper);
    TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
    todoMapper.insert(todoVO);
    log.info(todoVO);
  }

  @Override
  public List<TodoDTO> listTodos() {
    List<TodoVO> voList = todoMapper.findAll();
    return voList.stream().map(vo -> modelMapper.map(vo, TodoDTO.class)).collect(Collectors.toList());
  }

  @Override
  public TodoDTO getOne(Long tno) {
    return modelMapper.map(todoMapper.findById(tno), TodoDTO.class);
  }

  @Override
  public void remove(Long tno) {
    todoMapper.delete(tno);
  }

  @Override
  public void modify(TodoDTO todoDTO) {
    TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
    todoMapper.update(todoVO);
  }



}





