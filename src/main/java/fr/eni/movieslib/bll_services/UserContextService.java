package fr.eni.movieslib.bll_services;

import fr.eni.movieslib.bo.context.UserContext;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter @Setter
@Service
public class UserContextService {

    private UserContext userContext;

    public UserContextService() {
        userContext = new UserContext();
    }

    public UserContext setNewUser(String pseudo) {
        userContext = new UserContext(pseudo);
        return userContext;
    }

    public UserContext getUserContext() {
        return userContext;
    }

    public void flushSession() {
        userContext.setUsername(null);
    }
}
