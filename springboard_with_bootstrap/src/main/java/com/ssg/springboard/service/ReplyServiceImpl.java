package com.ssg.springboard.service;

import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;
import com.ssg.springboard.mappers.ReplyMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService{

  private final ReplyMapper replyMapper;

  @Override
  public Long register(ReplyVO replyVO) {
    replyMapper.insert(replyVO);
    return replyVO.getRno();     // 여기서 새로 생성된 rno를 꺼내서 반환
  }

  @Override
  public ReplyVO getOne(Long rno) {
    return replyMapper.selectOne(rno);
  }

  @Override
  public int modifyOne(ReplyVO replyVO) {
    return replyMapper.updateOne(replyVO);
  }

  @Override
  public int removeOne(Long rno) {
    return replyMapper.deleteOne(rno);
  }

  @Override
  public List<ReplyVO> getListWithBno(Criteria cri, Long bno) {
    return replyMapper.getReplyList(cri, bno);
  }
}
