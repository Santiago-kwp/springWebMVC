package springboard.mappers;


import com.ssg.springboard.domain.BoardVO;
import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;
import com.ssg.springboard.mappers.BoardMapper;
import com.ssg.springboard.mappers.ReplyMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j2
public class ReplyMapperTests {

  @Autowired(required = false)
  ReplyMapper replyMapper;


  @Test
  public void testInsert() {
    Long bno = 1525L;

    for (int i = 0; i < 20; i++) {
      ReplyVO replyVO = ReplyVO.builder()
          .replyText((i+1) + "번째 댓글입니다.")
          .bno(bno)
          .replyer("hongildong")
          .build();
      log.info(replyMapper.insert(replyVO));
    }

  }

  @Test
  public void testSelectOne() {
    replyMapper.selectOne(39L);
  }

  @Test
  public void testUpdate() {
    ReplyVO replyVO = replyMapper.selectOne(39L);
    replyVO.setReplyText("21st 댓글 수정입니다.");
    replyMapper.updateOne(replyVO);
  }

  @Test
  public void testDelete() {
    replyMapper.deleteOne(38L);
  }

  @Test
  public void getReplyListTest() {
    Criteria cri = new Criteria();
    // 1 10

    replyMapper.getReplyList(cri, 1525L).forEach(log::info);
  }

}
