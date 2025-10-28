//package com.ssg.membertest.service;
//
//import com.ssg.membertest.mapper.MemberMapper;
//import com.ssg.membertest.domain.MemberVO;
//import com.ssg.membertest.dto.MemberDTO;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.stream.Collectors;
//import lombok.RequiredArgsConstructor;
//import org.modelmapper.ModelMapper;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@Service
//@RequiredArgsConstructor
//public class MemberServiceImpl_VerJdbcTemplate implements MemberService{
//
//  private final MemberMapper memberMapper;
//  private final ModelMapper modelMapper;
//
//
//  @Override
//  @Transactional
//  public int createMember(MemberDTO dto) throws SQLException {
//    MemberVO vo = modelMapper.map(dto, MemberVO.class);
//    return memberMapper.insert(vo);
//  }
//
//  @Override
//  @Transactional
//  public List<MemberDTO> listMembers() throws SQLException {
//    List<MemberVO> voList = memberMapper.findAll();
//    List<MemberDTO> dtoList = voList.stream().map(vo -> modelMapper.map(vo, MemberDTO.class)).collect(
//        Collectors.toList());
//
//    return dtoList;
//  }
//
//}
//
