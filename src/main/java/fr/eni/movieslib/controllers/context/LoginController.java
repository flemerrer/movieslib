package fr.eni.movieslib.controllers.context;

import fr.eni.movieslib.bll_services.UserContextService;
import fr.eni.movieslib.bo.context.UserContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"userSession"})
public class LoginController {

    UserContextService service;

    public LoginController(UserContextService service) {
        this.service = service;
    }

    @ModelAttribute("userSession")
    public UserContext setUserSession() {
        return service.getUserContext();
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute("userSession") UserContext userSession,
            @RequestParam(required = false, name ="pseudo") String pseudo) {
        if (!pseudo.isEmpty()) {
            userSession = service.setNewUser(pseudo);
            System.out.println(userSession.getUsername() + " is logged in");
        } else {
            userSession.setUsername(null);
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(@ModelAttribute("userSession") UserContext userSession, SessionStatus status) {
        System.out.println(userSession.getUsername() + " is logged out");
        service.flushSession();
        return "redirect:/";
    }

}
