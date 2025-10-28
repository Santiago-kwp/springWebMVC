package com.ssg.membertest.controller;

import com.ssg.membertest.dto.MemberDTO;
import com.ssg.membertest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    /** 목록  /WEB-INF/views/member/list.jsp */
    @GetMapping
    public String list(Model model) {
        model.addAttribute("members", memberService.listMembers());
        return "member/list";
    }

    /** 등록 폼 *  /WEB-INF/views/member/form.jsp**/
    @GetMapping("/new")
    public String registerForm(Model model) {
        // 기본 joinDate 오늘로 세팅 (원하면 제거)
        MemberDTO empty = new MemberDTO();
        empty.setJoinDate(LocalDate.now());
        model.addAttribute("member", empty);
        return "member/form";
    }

    /** 등록 처리 */
    @PostMapping
    public String register(
            @ModelAttribute("member") @Valid MemberDTO member,
            BindingResult bindingResult,
            RedirectAttributes rttr
    ) {
        if (bindingResult.hasErrors()) {
            return "member/form";
        }

        try {
            memberService.createMember(member);
        } catch (DuplicateKeyException e) {
            // PK(mid) 중복 시 폼으로 되돌리기
            bindingResult.rejectValue("mid", "duplicate", "이미 사용 중인 아이디입니다.");
            return "member/form";
        }

        rttr.addFlashAttribute("msg", "회원이 등록되었습니다.");
        return "redirect:/members";
    }

    /** 상세보기   // /WEB-INF/views/member/detail.jsp */
    @GetMapping("/{mid}")
    public String detail(@PathVariable String mid, Model model) {
        MemberDTO found = memberService.findById(mid);
        if (found == null) {
            model.addAttribute("error", "해당 아이디의 회원을 찾을 수 없습니다.");
            return "member/detail"; // 에러 메시지만 보여주도록
        }
        model.addAttribute("member", found);
        return "member/detail";
    }

    /** 중복키 등 전역 예외 메시지  처리 */
    @ExceptionHandler(DuplicateKeyException.class)
    public String handleDupKey(DuplicateKeyException ex, Model model) {
        model.addAttribute("error", "중복된 키로 인해 저장에 실패했습니다.");
        return "member/form";
    }



}
