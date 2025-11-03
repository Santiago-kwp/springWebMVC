package com.ssg.springboard.mappers;

import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ReplyMapper {

  Long insert(ReplyVO replyVO);
  ReplyVO selectOne(Long rno);

  int updateOne(ReplyVO replyVO);
  int deleteOne(Long rno);
  List<ReplyVO> getReplyList(@Param("cri")Criteria cri, @Param("bno") Long bno);





}
