package com.ssg.membertest.dao;

import com.ssg.membertest.domain.MemberVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;


@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO{

  private final DataSource dataSource;

  @Override
  public int insertMember(MemberVO vo) throws SQLException {
    String sql = "insert into member (mid, mpw, mname) values (?, ?, ?)";

    try (Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {

      pstmt.setString(1, vo.getMid());
      pstmt.setString(2, vo.getMpw());
      pstmt.setString(3, vo.getMname());

      int result = pstmt.executeUpdate();

      pstmt.close();
      return result;
    }

  }

  @Override
  public List<MemberVO> selectMembers() throws SQLException {
    String sql = "select * from member";

    try (Connection connection = dataSource.getConnection();
        PreparedStatement pstmt = connection.prepareStatement(sql)) {

      ResultSet rs = pstmt.executeQuery();

      List<MemberVO> list = new ArrayList<>();

      while(rs.next()) {
        MemberVO vo = MemberVO.builder()
            .mid(rs.getString("mid"))
            .mpw(rs.getString("mpw"))
            .mname(rs.getString("mname"))
            .build();

        list.add(vo);
      }

      rs.close();
      return list;
    }

  }
}
