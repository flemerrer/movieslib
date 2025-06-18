package fr.eni.movieslib.controllers.context;

import fr.eni.movieslib.bo.context.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"userSession"})
public class LoginController {

    @ModelAttribute("userSession")
    public User setUserSession() {
        return new User();
    }

    @GetMapping("/login")
    public String login(
            @ModelAttribute("userSession") User userSession,
            @RequestParam(required = false, name ="pseudo") String pseudo,
            Model model) {
        User requestLogin = new User(pseudo);
        model.addAttribute("userRequest", requestLogin);
        if (pseudo != null) {
            userSession.setUsername(pseudo);
        } else {
            userSession.setUsername(null);
        }
        System.out.println(userSession.getUsername() + " is logged in");
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(@ModelAttribute("userSession") User userSession, SessionStatus status) {
        status.setComplete();
        System.out.println(userSession.getUsername() + " is logged out");
        return "redirect:/";
    }

}
