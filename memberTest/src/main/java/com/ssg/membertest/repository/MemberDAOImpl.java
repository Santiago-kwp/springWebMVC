package com.ssg.membertest.repository;

import com.ssg.membertest.dto.MemberDTO;
import com.ssg.membertest.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {

    private final MemberMapper memberMapper;

    @Override
    public int insert(MemberDTO dto) {
        return memberMapper.insert(dto);
    }

    @Override
    public List<MemberDTO> findAll() {
        return memberMapper.findAll();
    }
}
