package com.ssg.boardservice.mapper;

import com.ssg.boardservice.domain.BoardVO;import java.util.List;public interface BoardMapper {

  void insert(BoardVO vo);
  List<BoardVO> findAll();
  BoardVO findById(Long bId);
  void delete(Long bId);
  void update(BoardVO boardVO);
  void increaseHits(Long bId);


}
