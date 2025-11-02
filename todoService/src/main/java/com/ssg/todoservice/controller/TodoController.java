package com.ssg.todoservice.controller;

import com.ssg.todoservice.dto.PageRequestDTO;
import com.ssg.todoservice.dto.TodoDTO;
import com.ssg.todoservice.service.TodoService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/todo")
@Log4j2
@RequiredArgsConstructor
public class TodoController {

  private final TodoService todoService;

//  @RequestMapping("/list")
//  public void list(Model model) {
//    log.info("todo list");
//    model.addAttribute("dtoList", todoService.listTodos());
//  }
  @GetMapping("/list")
  public void list(@Valid PageRequestDTO pageRequestDTO, BindingResult bindingResult, Model model) {
    log.info("pageRequestDTO: " + pageRequestDTO);
    log.info("keyword: {}", pageRequestDTO.getKeyword());
    log.info("types: {}", pageRequestDTO.getTypes());

    if (bindingResult.hasErrors()) {
      pageRequestDTO = PageRequestDTO.builder().build();
      log.info("Error generated!! pageRequestDTO: " + pageRequestDTO);

    }
    // ✅ normalize 호출 추가
    pageRequestDTO.normalize();

    model.addAttribute("responseDTO", todoService.getList(pageRequestDTO));
  }

  @RequestMapping("/register")
  public void register() {
    log.info("todo register form Page");
  }

  /** 등록 처리 */
  @PostMapping("/register")
  public String register(
      @ModelAttribute("todo") @Valid TodoDTO todo,
      BindingResult bindingResult,
      RedirectAttributes rttr
  ) {
    log.info("POST todo register");

    //  유효성 검사 오류 발생 시 Todo 등록 화면 리다이렉트
    //  입력했던 데이터도 todoDTO에 저장하여 같이 전달한다.

    if (bindingResult.hasErrors()) {
      log.error("POST todo register has errors...");
      rttr.addFlashAttribute("errors", bindingResult.getAllErrors());
      return "redirect:/todo/register";
    }

    // 오류미 발생시 등록 성공처리 후 todo/list 로 리다이렉트
    log.info(todo);
    // flash 라서 한번만 뜸
    rttr.addFlashAttribute("msg", "Todo가 등록되었습니다.");
    todoService.register(todo);
    return "redirect:/todo/list";

  }

  @GetMapping({"/read", "/modify"})
  public void read(Long tno, Model model) {
    TodoDTO dto = todoService.getOne(tno);
    log.info(dto);
    model.addAttribute("dto", dto);
  }

  @PostMapping("/remove")
  public String remove(Long tno, RedirectAttributes redirectAttributes) {
    log.info("-------------remove------------------");
    todoService.remove(tno);
    log.info("tno: " + tno);
    redirectAttributes.addFlashAttribute("msg", "Todo가 삭제되었습니다.");
    return "redirect:/todo/list";
  }

  @PostMapping("/modify")
  public String modify(@Valid TodoDTO todoDTO,
                       BindingResult bindingResult,
                       RedirectAttributes rttr) {

    if (bindingResult.hasErrors()) {
      log.info("has errors.......");
      rttr.addFlashAttribute("errors", bindingResult.getAllErrors());
      rttr.addAttribute("tno", todoDTO.getTno());
      return "redirect:/todo/modify";
    }
    log.info(todoDTO);
    todoService.modify(todoDTO);
    rttr.addFlashAttribute("msg", todoDTO.getTitle() + " Todo가 수정되었습니다.");
    return "redirect:/todo/list";
  }







}
