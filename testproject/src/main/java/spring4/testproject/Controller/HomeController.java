package spring4.testproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import spring4.testproject.Form.LoginForm;
import spring4.testproject.Model.Member;
import spring4.testproject.Service.MemberService;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final LoginForm loginForm;

    private final MemberService memberService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", loginForm);
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm, Model model) {

        String userId = loginForm.getUserId();
        String userPwd = loginForm.getUserPwd();

        Member member = new Member();
        member.setUserId(userId);
        member.setUserPwd(userPwd);

        boolean memberCheck = memberService.memberCrossCheck(member);
        if (memberCheck) {
            System.out.println("로그인 성공!!");
            System.out.println("ID : " + member.getUserId() + " Password : " + member.getUserPwd());
        } else {
            System.out.println("로그인 실패....");
        }
        return null;
    }
}
