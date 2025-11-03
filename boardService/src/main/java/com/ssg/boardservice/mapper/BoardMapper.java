package com.ssg.boardservice.mapper;

import com.ssg.boardservice.domain.BoardVO;
import com.ssg.boardservice.domain.Criteria;
import java.util.List;public interface BoardMapper {


  List<BoardVO> getList();

  List<BoardVO> getPage(Criteria criteria);

  int getTotal(Criteria criteria);

  void insert(BoardVO vo);
  BoardVO findById(Long bno);
  void delete(Long bno);
  void update(BoardVO boardVO);
  void increaseHits(Long bno);


}
