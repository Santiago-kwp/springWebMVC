package com.ssg.springboard.service;

import com.ssg.springboard.domain.BoardVO;
import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.mappers.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@RequiredArgsConstructor
@Transactional
public class BoardService {

  private final BoardMapper boardMapper;

  public java.util.List<BoardVO> getList(Criteria criteria){

    return boardMapper.getPage(criteria);
  }

  public int getTotal(Criteria criteria){

    return boardMapper.getTotal(criteria);
  }

  public Long register(BoardVO boardVO){

    log.info("--------------"+ boardVO);

    int count = boardMapper.insert(boardVO);

    return boardVO.getBno();

  }

  public java.util.List<BoardVO> list() {

    return boardMapper.getList();

  }

  public BoardVO get(Long bno) {

    return boardMapper.select(bno);
  }

  public boolean modify(BoardVO vo){

    return boardMapper.update(vo) == 1;
  }

  public boolean remove(Long bno) {
    return true;
  }
}
