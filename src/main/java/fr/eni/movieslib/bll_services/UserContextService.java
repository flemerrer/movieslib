package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.context.UserContext;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Getter @Setter
@Service
@Profile("prod")
public class UserContextService {

    private UserContext userContext;
    private UserService userService;

    public UserContextService(UserService userService) {
        this.userContext = new UserContext();
        this.userService = userService;
    }

    public UserContext setNewUser(String email) {
        userContext = new UserContext(userService.findByEmail(email));
        return userContext;
    }

    public void flushSession() {
        userContext.setUsername(null);
    }
}
