package com.ssg.membertest.mapper;

import java.util.List;

import com.ssg.membertest.dto.MemberDTO;
import org.apache.ibatis.annotations.Param;

public interface MemberMapper {
  int insert(MemberDTO member);
  List<MemberDTO> findAll();
  // Controller 통해서 받는 @Param
  MemberDTO findById(@Param("mid") String mid);

}

