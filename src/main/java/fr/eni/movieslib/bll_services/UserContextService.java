package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.context.UserContext;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter @Setter
@Service
public class UserContextService {

    private UserContext userContext;
    private UserService userService;

    public UserContextService(UserService userService) {
        this.userContext = new UserContext();
        this.userService = userService;
    }

    public UserContext setNewUser(String pseudo) {
        userContext = new UserContext(userService.getUserByName(pseudo));
        return userContext;
    }

    public void flushSession() {
        userContext.setUsername(null);
    }
}
