package com.ssg.boardservice.service;

import com.ssg.boardservice.dto.BoardDTO;
import com.ssg.boardservice.dto.BoardRegisterDTO;
import java.io.IOException;
import java.util.List;
import javax.validation.Valid;

public interface BoardService {

  void create(@Valid BoardRegisterDTO dto) throws IOException;
  BoardDTO getBoard(Long bId);
  List<BoardDTO> listBoard();
  void remove(Long bId);
  void modify(BoardDTO boardDTO);




}
