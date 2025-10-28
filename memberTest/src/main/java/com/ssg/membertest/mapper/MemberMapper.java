package com.ssg.membertest.mapper;

import com.ssg.membertest.domain.MemberVO;
import java.util.List;

import com.ssg.membertest.dto.MemberDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface MemberMapper {


  int insert(MemberDTO member);
  List<MemberDTO> findAll();
  MemberDTO findById(@Param("mid") String mid);

}

