package com.ssg.todoservice.service;

import com.ssg.todoservice.domain.TodoVO;
import com.ssg.todoservice.dto.PageRequestDTO;
import com.ssg.todoservice.dto.PageResponseDTO;
import com.ssg.todoservice.dto.TodoDTO;
import com.ssg.todoservice.mapper.TodoMapper;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.apache.ibatis.logging.LogFactory;

import javax.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
@Log4j2
public class TodoServiceImpl implements TodoService{

  private final TodoMapper todoMapper;
  private final ModelMapper modelMapper;

  @PostConstruct
  public void forceMyBatisLog4j2() {
    System.out.println(">>> Forcing MyBatis to use Log4j2");
    LogFactory.useLog4J2Logging();
  }

  @Override
  public void register(TodoDTO todoDTO) {
    TodoVO todoVO = modelMapper.map(todoDTO, TodoVO.class);
    todoMapper.insert(todoVO);
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

  @Override
  public PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO) {
    List<TodoVO> voList = todoMapper.findList(pageRequestDTO);

    List<TodoDTO> dtoList = voList.stream()
            .map(vo -> modelMapper.map(vo,TodoDTO.class))
            .collect(Collectors.toList());

    int total = todoMapper.getCount(pageRequestDTO);

    PageResponseDTO<TodoDTO> pageResponseDTO =
        PageResponseDTO.<TodoDTO>withAll()
        .dtoList(dtoList).total(total).pageRequestDTO(pageRequestDTO).build();


    return pageResponseDTO;
  }


}





