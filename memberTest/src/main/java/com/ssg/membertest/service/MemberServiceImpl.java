package com.ssg.membertest.service;

import com.ssg.membertest.dto.MemberDTO;
import com.ssg.membertest.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberMapper memberMapper;

    @Override
    @Transactional
    public void createMember(MemberDTO dto) {
        memberMapper.insert(dto);
    }

    @Override
    @Transactional
    public List<MemberDTO> listMembers() {
        return memberMapper.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public MemberDTO findById(String mid) {
        return memberMapper.findById(mid);
    }
}
