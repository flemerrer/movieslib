package fr.eni.movieslib.controllers.context;

import fr.eni.movieslib.bll_services.UserContextService;
import fr.eni.movieslib.bll_services.UserService;
import fr.eni.movieslib.bo.context.UserContext;
import fr.eni.movieslib.bo.users.RegisteredUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"userSession"})
public class LoginController {

    UserService userService;
    UserContextService service;

    public LoginController(UserContextService service, UserService userService) {
        this.userService = userService;
        this.service = service;
    }

    @ModelAttribute("userSession")
    public UserContext setUserSession() {
        return service.getUserContext();
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute("userSession") UserContext userSession,
            @RequestParam(required = false, name ="email") String email) {
        if (!email.isEmpty()) {
            RegisteredUser queriedUser = userService.getUserByName(userSession.getUsername());
            if (queriedUser != null) {
                userSession = service.setNewUser(queriedUser.getEmail());
            } else {
                userService.addUser(new RegisteredUser(null, null, email, null));
                userSession = service.setNewUser(email);
            }
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
