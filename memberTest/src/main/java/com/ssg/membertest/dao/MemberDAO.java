package com.ssg.membertest.dao;

import com.ssg.membertest.domain.MemberVO;
import java.sql.SQLException;
import java.util.List;

public interface MemberDAO {

  public int insertMember(MemberVO vo) throws SQLException;

  public List<MemberVO> selectMembers() throws SQLException;

}
