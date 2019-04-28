package court.web;

import court.domain.Member;
import court.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/member/*")
@Controller
public class MemberController {

    private MemberService memberService;

    // 애플리케이션 컨텍스트에서 사용 가능한 서비스를 생성자에 연결합니다.
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("add")
    public String addMember(Model model) {
        model.addAttribute("member", new Member());
        model.addAttribute("guests", memberService.list());
        return "memberList";
    }


    // 메서드를 /member/remove, /member/delete 두 URL에 매핑합니다.
    @RequestMapping(value = {"remove", "delete"}, method = RequestMethod.GET)
    public String removeMember(@RequestParam("memberName")
                                       String memberName) {
        memberService.remove(memberName);

        // 리스트를 갱신하기 위해 리다이렉트합니다.
        return "redirect:";
    }

    @RequestMapping("display/{member}")
    public String displayMember(@PathVariable("member") String member, Model model) {
        model.addAttribute("member", memberService.find(member).orElse(null));
        return "member";
    }

    @RequestMapping
    public void memberList() {}

    public void memberLogic(String memberName) {}
}
