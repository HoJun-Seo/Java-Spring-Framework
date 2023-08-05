package spring4.testproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @PostMapping("/login")
    public String login(Model model) {

        model.addAttribute("loginKey", "loginValue");
        return "login";
    }

}
