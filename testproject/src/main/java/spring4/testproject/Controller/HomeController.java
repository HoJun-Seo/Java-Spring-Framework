package spring4.testproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import spring4.testproject.Form.DeleteForm;
import spring4.testproject.Form.LoginForm;
import spring4.testproject.Form.RegisterForm;
import spring4.testproject.Form.UpdateForm;
import spring4.testproject.Interface.ServiceInterface.MemberService;
import spring4.testproject.Model.Member;
import org.springframework.web.bind.annotation.PutMapping;

import com.fasterxml.jackson.core.JsonProcessingException;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final LoginForm loginForm;
    private final RegisterForm registerForm;
    private final UpdateForm updateForm;
    private final DeleteForm deleteForm;

    private final MemberService memberService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", loginForm);
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("registerForm", registerForm);
        return "register";
    }

    @GetMapping("/update")
    public String update(Model model) {
        model.addAttribute("updateForm", updateForm);
        return "update";
    }

    @GetMapping("/delete")
    public String delete(@ModelAttribute Member member, Model model) {
        model.addAttribute("memberData", member);
        System.out.println("회원탈퇴 페이지 이동 : " + member.getUserId() + ", " + member.getUserPwd());
        model.addAttribute("deleteForm", deleteForm);
        return "delete";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginForm loginForm, Model model) throws JsonProcessingException {

        String userId = loginForm.getUserId();
        String userPwd = loginForm.getUserPwd();

        Member member = new Member();
        member.setUserId(userId);
        member.setUserPwd(userPwd);

        String searchResult = memberService.memberLogin(member);
        if (searchResult.equals("loginSuccess")) {
            System.out.println("로그인 성공!");
            model.addAttribute("loginConfirm", "loginSuccess");
            model.addAttribute("memberData", member);
            return "/confirm/loginConfirm";
        } else if (searchResult.equals("pwdNotMatch")) {
            System.out.println("비밀번호가 일치하지 않습니다.");
            model.addAttribute("loginConfirm", "notMatchPwd");
            return "/confirm/loginConfirm";
        } else {
            System.out.println("존재하지 않는 계정입니다.");
            model.addAttribute("loginConfirm", "notExistAccount");
            return "/confirm/loginConfirm";
        }
    }

    @PostMapping("/loginIndex")
    public String loginIndex(@ModelAttribute Member member, Model model) {
        model.addAttribute("memberData", member);
        return "loginIndex";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterForm registerForm, Model model) {

        String userId = registerForm.getUserId();
        String userPwd = registerForm.getUserPwd();

        Member member = new Member();
        member.setUserId(userId);
        member.setUserPwd(userPwd);

        String registerResult = memberService.memberRegister(member);
        if (registerResult.equals("existMember")) {
            System.out.println("이미 존재하는 계정입니다.");
            model.addAttribute("exist", "alreadyExist");
        } else {
            System.out.println("회원가입이 성공적으로 완료 되었습니다.");
            model.addAttribute("exist", "registerSuccess");
        }
        return "/confirm/registerConfirm";
    }

    @PutMapping("/update")
    public String memberUpdate(@ModelAttribute UpdateForm updateForm, Model model) {

        // 현재 userId 에 해당하는 정보가 존재하는지 확인

        Member currentMember = new Member();
        currentMember.setUserId(updateForm.getCurrentUserId());
        currentMember.setUserPwd(updateForm.getCurrentUserPwd());

        Member updatMember = new Member();
        updatMember.setUserId(updateForm.getCurrentUserId());
        updatMember.setUserPwd(updateForm.getUpdateUserPwd());

        String updateResult = memberService.memberUpdate(currentMember, updatMember);
        if (updateResult.equals("updateFail")) {
            System.out.println("수정하고자 하는 유저 정보가 존재하지 않습니다.");
            model.addAttribute("updateConfirm", "updateFail");
        } else if (updateResult.equals("notMatchCurrentPwd")) {
            System.out.println("현재 비밀번호가 일치하지 않습니다.");
            model.addAttribute("updateConfirm", "notMatchCurrentPwd");
        } else if (updateResult.equals("updateSuccess")) {
            System.out.println("유저 정보 수정이 성공적으로 완료 되었습니다.");
            model.addAttribute("updateConfirm", "updateSuccess");
        }
        return "/confirm/updateConfirm";
    }

    @DeleteMapping("/delete")
    public String memberDelete(@ModelAttribute DeleteForm deleteForm, Model model) {

        Member member = new Member();
        member.setUserId(deleteForm.getDeleteUserId());
        member.setUserPwd(deleteForm.getDeleteUserPwd());
        System.out.println("회원탈퇴 메소드 호출 : " + member.getUserId() + ", " + member.getUserPwd());
        String deleteResult = memberService.memberDelete(member);

        if (deleteResult.equals("deleteFail")) {
            System.out.println("삭제할 유저의 계정이 존재하지 않습니다.");
            model.addAttribute("deleteConfirm", "deleteFail");
        } else if (deleteResult.equals("deleteSucess")) {
            System.out.println("성공적으로 유저의 정보가 삭제 되었습니다.");
            model.addAttribute("deleteConfirm", "deleteSucess");
        } else {
            System.out.println("삭제할 유저의 현재 비밀번호가 일치하지 않습니다.");
            model.addAttribute("memberData", member);
            model.addAttribute("deleteConfirm", "notMatchPwd");
        }
        return "/confirm/deleteConfirm";

    }
}