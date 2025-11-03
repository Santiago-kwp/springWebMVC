package com.ssg.boardservice.controller;


import com.ssg.boardservice.domain.BoardVO;
import com.ssg.boardservice.domain.Criteria;
import com.ssg.boardservice.domain.PageDTO;
import com.ssg.boardservice.dto.BoardDTO;
import com.ssg.boardservice.dto.BoardRegisterDTO;
import com.ssg.boardservice.service.BoardService;
import java.io.IOException;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.util.List;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/board")
@Log4j2
@RequiredArgsConstructor
public class BoardController {

  private final BoardService boardService;

  @RequestMapping("/list")
  public void list(@ModelAttribute("cri") Criteria criteria,
      Model model) {
    log.info("list................");
    log.info("criteria: " + criteria);

    List<BoardDTO> list = boardService.getList(criteria);

    log.info(list);
    log.info("리스트 출력");

    model.addAttribute("boards", list);

    PageDTO pageDTO = new PageDTO(criteria, boardService.getTotal(criteria));

    model.addAttribute("pageMaker", pageDTO);
  }

  // 등록 폼 페이지
  @GetMapping("/register")
  public void registerForm(Model model) { // ModelAttribute를 제거하고, 빈 DTO를 모델에 추가
    log.info("board register form Page");
  }


  /** 등록 처리 */
  @PostMapping("/register")
  public String register(
      @ModelAttribute("boardRegisterDTO") @Valid BoardRegisterDTO boardRegisterDTO, // BoardRegisterDTO 사용
      BindingResult bindingResult,
      RedirectAttributes rttr
  ) {
    log.info("Board register init!");
    if (bindingResult.hasErrors()) {
      log.info("Board Binding Error!");
      bindingResult.getAllErrors().forEach(e -> log.error(e.getDefaultMessage())); // 에러 로깅
      return "board/register";
    }

    try {
      boardService.create(boardRegisterDTO); // BoardRegisterDTO 전달
    } catch (DuplicateKeyException e) {
      bindingResult.rejectValue("bno", "duplicate", "이미 등록된 게시글입니다."); // bno 필드가 없으므로, 다른 필드나 글로벌 오류로 처리
      log.error("Duplicate key error: " + e.getMessage());
      return "board/register";
    } catch (IOException e) {
      log.info("파일 저장 중 문제 발생!!");
      return "board/register";
    }

    rttr.addFlashAttribute("msg", "새 게시글이 등록되었습니다.");
    return "redirect:/board/list";
  }

  @GetMapping({"/{job}/{bno}"})
  public String read(
      @PathVariable(name = "job") String job,
      @PathVariable(name = "bno") Long bno,
      @ModelAttribute("cri") Criteria criteria,
      Model model) {

    log.info("job: " + job);
    log.info("bno: " + bno);

    if (!(job.equals("read") || job.equals("modify"))) {
      throw new RuntimeException("Bad Request job");
    }

    BoardDTO boardDTO = boardService.getBoard(bno);

    log.info("boardDTO: " + boardDTO);

    model.addAttribute("dto", boardDTO);

    return "/board/" + job;

  }



  @PostMapping("/remove")
  public String remove(Long bno, RedirectAttributes redirectAttributes) {
    log.info("-------------remove------------------");
    boardService.remove(bno);
    log.info("bno: " + bno);
    redirectAttributes.addFlashAttribute("msg", "Board가 삭제되었습니다.");
    return "redirect:/board/list";
  }

  @PostMapping("/modify")
  public String modify(@Valid BoardDTO todoDTO,
      BindingResult bindingResult,
      RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      log.info("has errors.......");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
      redirectAttributes.addAttribute("bno", todoDTO.getBno());
      return "redirect:/board/modify";
    }

    log.info(todoDTO);
    boardService.modify(todoDTO);
    redirectAttributes.addFlashAttribute("msg", todoDTO.getTitle() + " Todo가 수정되었습니다.");
    return "redirect:/board/list";
  }





}
