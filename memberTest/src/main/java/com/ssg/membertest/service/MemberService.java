package com.ssg.membertest.service;

import com.ssg.membertest.domain.MemberVO;
import com.ssg.membertest.dto.MemberDTO;
import java.sql.SQLException;
import java.util.List;

public interface MemberService {

  void createMember(MemberDTO dto);

  List<MemberDTO> listMembers();

  MemberDTO findById(String mid);

}
