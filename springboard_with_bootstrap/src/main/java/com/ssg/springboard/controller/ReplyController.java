package com.ssg.springboard.controller;

import com.ssg.springboard.domain.BoardVO;
import com.ssg.springboard.domain.Criteria;
import com.ssg.springboard.domain.ReplyVO;
import com.ssg.springboard.service.ReplyService;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.geom.AreaOp;

@RestController
@RequestMapping("/replys")
@RequiredArgsConstructor
public class ReplyController {

  private final ReplyService replyService;

  // String 이지만 json 형태로 주고 싶어! => produces = MediaType.APPLICATION_JSON_VALUE ;
  //consumes 도 있음.
  @GetMapping(value = "/sample", produces = MediaType.APPLICATION_JSON_VALUE)
  public String sample() {

//    return Map.of("value1", "AAAA", "value2", "BBBB"); => json 방식으로 전달됨.
    return "Hello RestController";
  }

  @GetMapping(value = "/{rno}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ReplyVO getOne(@PathVariable("rno") Long rno) {
    return replyService.getOne(rno);
  }

  @GetMapping(value = "/list/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ReplyVO> getListWithBno(
      @PathVariable("bno") Long bno,
      @RequestParam(value = "page", defaultValue = "1") int pageNum,
      @RequestParam(value = "amount", defaultValue = "10") int amount
  ) {
    Criteria criteria = new Criteria();
    criteria.setPageNum(pageNum);
    criteria.setAmount(amount);

    return replyService.getListWithBno(criteria, bno);
  }



  @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
  public ReplyVO registerReply(@RequestBody ReplyVO replyVO) {
    Long rno = replyService.register(replyVO);
    return replyService.getOne(rno);
  }

  @PutMapping(value = "/{rno}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  public ReplyVO modifyReply(@PathVariable("rno") Long rno, @RequestBody ReplyVO replyVO) {
    replyVO.setRno(rno);
    replyService.modifyOne(replyVO);
    return replyService.getOne(rno);
  }

  @DeleteMapping(value = "/{rno}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> removeReply(@PathVariable("rno") Long rno) {
    int result = replyService.removeOne(rno);
    if (result > 0) {
      return ResponseEntity.ok("삭제에 성공하셨습니다.");
    } else {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("삭제 중 오류발생!");
    }
  }





}
