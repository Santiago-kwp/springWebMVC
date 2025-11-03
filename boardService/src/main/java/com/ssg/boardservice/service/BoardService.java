package com.ssg.boardservice.service;

import com.ssg.boardservice.domain.BoardVO;
import com.ssg.boardservice.domain.Criteria;
import com.ssg.boardservice.dto.BoardDTO;
import com.ssg.boardservice.dto.BoardRegisterDTO;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;

public interface BoardService {

  void create(@Valid BoardRegisterDTO dto) throws IOException;
  BoardDTO getBoard(Long bno);
  void remove(Long bno);
  void modify(BoardDTO boardDTO);

  List<BoardDTO> getList(Criteria criteria);
  int getTotal(Criteria criteria);







}
