package com.ssg.springboard.service;

import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplyService {

  Long register(ReplyVO replyVO);
  ReplyVO getOne(Long rno);
  int modifyOne(ReplyVO replyVO);
  int removeOne(Long rno);
  List<ReplyVO> getListWithBno(@Param("cri") Criteria cri, @Param("bno") Long bno);

}
