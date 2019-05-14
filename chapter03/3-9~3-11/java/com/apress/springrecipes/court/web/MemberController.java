package com.apress.springrecipes.court.web;

import com.apress.springrecipes.court.domain.Member;
import com.apress.springrecipes.court.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/member/*")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("add")
    public String addMember(Model model){
        model.addAttribute("member", new Member());
        model.addAttribute("guests", memberService.list());
        return "memberList";
    }

    @RequestMapping(value = {"remove", "delete"}, method = RequestMethod.GET)
    public String removeMember(@RequestParam("memberName")
                                       String memberName) {
        memberService.remove(memberName);

        // 리스트를 갱신하기 위해 리다이렉트합니다.
        return "redirect:";
    }

//    @RequestMapping("display/{member}")
//    public String displayMember(@PathVariable("member") String member, Model model) {
//        model.addAttribute("member", memberService.find(member).orElse(null));
//        return "member";
//    }

    @RequestMapping
    public void memberList() {}

    public void memberLogic(String memberName) {}
}