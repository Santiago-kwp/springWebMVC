package com.ssg.membertest.service;

import com.ssg.membertest.dto.MemberDTO;
import com.ssg.membertest.mapper.MemberMapper;
import com.ssg.membertest.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Override
    @Transactional
    public void createMember(MemberDTO dto) {
        memberDAO.insert(dto);
    }

    @Override
    @Transactional
    public List<MemberDTO> listMembers() {
        return memberDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public MemberDTO findById(String mid) {
        return memberDAO.findById(mid);
    }
}
