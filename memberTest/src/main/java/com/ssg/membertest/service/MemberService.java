package com.ssg.membertest.service;

import com.ssg.membertest.domain.MemberVO;
import com.ssg.membertest.dto.MemberDTO;
import java.sql.SQLException;
import java.util.List;

public interface MemberService {

  public int createMember(MemberDTO dto) throws SQLException;

  public List<MemberDTO> listMembers() throws SQLException;

}
