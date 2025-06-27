package fr.eni.movieslib.controllers.context;

import fr.eni.movieslib.bll_services.UserContextService;
import fr.eni.movieslib.bll_services.UserService;
import fr.eni.movieslib.bo.context.UserContext;
import fr.eni.movieslib.bo.users.RegisteredUser;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes({"userSession"})
public class LoginController {

    private final UserContextService userContextService;
    UserService userService;
    UserContextService service;

    public LoginController(UserContextService contextService, UserService userService, UserContextService userContextService) {
        this.userService = userService;
        this.service = contextService;
        this.userContextService = userContextService;
    }

    @ModelAttribute("userSession")
    public UserContext setUserSession() {
        return service.getUserContext();
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute("userSession") UserContext userSession,
            @RequestParam(required = false, name ="email") String email) {
        RegisteredUser queriedUser = userService.findByEmail(email);
        if (queriedUser != null) {
            userSession.setEmail(queriedUser.getEmail());
            if (queriedUser.isAdmin()) {
                System.out.println(queriedUser.isAdmin());
                userSession.setAdmin(true);
            }
        }
        System.out.println("userSession: " + userSession + " " + userSession.isAdmin());
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(@ModelAttribute("userSession") UserContext userSession, SessionStatus status) {
        service.flushSession();
        return "redirect:/";
    }

}
