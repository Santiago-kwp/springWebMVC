//package com.ssg.membertest.repository;
//
//import com.ssg.membertest.domain.MemberVO;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Primary;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//@Repository
//@Primary
//@RequiredArgsConstructor
//public class MemberDAOImpl_VerjdbcTemplate implements MemberDAO{
//
//  private final JdbcTemplate jdbcTemplate;
//
//  // 익명 클래스 정의
//  private static final RowMapper<MemberVO> MEMBER_VO_ROW_MAPPER = new RowMapper<MemberVO>() {
//
//    @Override
//    public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//      MemberVO memberVO = MemberVO.builder()
//          .mid(rs.getString("mid"))
//          .mpw(rs.getString("mpw"))
//          .mname(rs.getString("mname"))
//          .build();
//      return memberVO;
//    }
//  };
//
//  @Override
//  public int insert(MemberVO vo) {
//    String sql = "INSERT INTO member(mid, mpw, mname)" + "VALUES (?, ?, ?)";
//
//    return jdbcTemplate.update(sql,
//        vo.getMid(), vo.getMpw(), vo.getMname());
//  }
//
//  @Override
//  public List<MemberVO> findAll() {
//    String sql = "SELECT mid, mpw, mname FROM member ORDER BY mid";
//    return jdbcTemplate.query(sql, MEMBER_VO_ROW_MAPPER);
//  }
//
//}
