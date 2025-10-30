package com.ssg.todoservice.controller;

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

  @RequestMapping("/list")
  public void list(Model model) {
    log.info("todo list");
    model.addAttribute("todos", todoService.listTodos());
  }

  @RequestMapping("/register")
  public void register() {
    log.info("todo register form Page");
  }

  /** 등록 처리 */
  @PostMapping
  public String register(
      @ModelAttribute("todo") @Valid TodoDTO todo,
      BindingResult bindingResult,
      RedirectAttributes rttr
  ) {
    if (bindingResult.hasErrors()) {
      return "register";
    }

    try {
      todoService.register(todo);
    } catch (DuplicateKeyException e) {
      // PK(mid) 중복 시 폼으로 되돌리기
      bindingResult.rejectValue("tno", "duplicate", "이미 등록된 Todo입니다.");
      return "register";
    }

    // flash 라서 한번만 뜸
    rttr.addFlashAttribute("msg", "Todo가 등록되었습니다.");
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
                       RedirectAttributes redirectAttributes) {
    if (bindingResult.hasErrors()) {
      log.info("has errors.......");
      redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
      redirectAttributes.addAttribute("tno", todoDTO.getTno());
      return "redirect:/todo/modify";
    }
    log.info(todoDTO);
    todoService.modify(todoDTO);
    redirectAttributes.addFlashAttribute("msg", todoDTO.getTitle() + " Todo가 수정되었습니다.");
    return "redirect:/todo/list";
  }







}
