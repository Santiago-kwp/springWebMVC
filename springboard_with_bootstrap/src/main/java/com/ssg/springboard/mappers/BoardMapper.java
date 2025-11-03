package com.ssg.springboard.mappers;

import com.ssg.springboard.domain.BoardVO;
import com.ssg.springboard.domain.Criteria;

public interface BoardMapper {

  java.util.List<BoardVO> getList();

  java.util.List<BoardVO> getPage(Criteria criteria);

  int getTotal(Criteria criteria);


  int insert(BoardVO boardVO);

  BoardVO select(Long bno);

  int update(BoardVO boardVO);

}
