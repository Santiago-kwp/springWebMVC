package com.ssg.membertest.mapper;

import com.ssg.membertest.domain.MemberVO;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {


  @Insert("INSERT INTO member(mid, mpw, mname) VALUES (#{mid}, #{mpw}, #{mname})")
  int insert(MemberVO vo);


  @Select("SELECT mid, mpw, mname FROM member ORDER BY mid")
  List<MemberVO> findAll();

}
