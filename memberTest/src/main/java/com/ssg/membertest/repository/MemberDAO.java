package com.ssg.membertest.repository;

import com.ssg.membertest.domain.MemberVO;
import com.ssg.membertest.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
  int insert(MemberDTO dto);
  List<MemberDTO> findAll();

}
