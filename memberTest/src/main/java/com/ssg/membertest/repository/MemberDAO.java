package com.ssg.membertest.repository;

import com.ssg.membertest.domain.MemberVO;
import java.util.List;

public interface MemberDAO {
  int insert(MemberVO vo);
  List<MemberVO> findAll();

}
