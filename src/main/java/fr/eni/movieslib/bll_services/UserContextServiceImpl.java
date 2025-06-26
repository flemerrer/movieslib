package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.context.UserContext;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter @Setter
@Service
public class UserContextServiceImpl {

    private UserContext userContext;
    private UserService userService;

    public UserContextServiceImpl(UserService userService) {
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
