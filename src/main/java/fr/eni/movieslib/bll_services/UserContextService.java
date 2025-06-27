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

    public UserContextService() {
        this.userContext = new UserContext();
    }

    public UserContext setUserContext(String email) {
        userContext = new UserContext();
        userContext.setEmail(email);
        return userContext;
    }

    public void flushSession() {
        userContext.setEmail(null);
    }

    public void setAdmin() {
        userContext.setAdmin(true);
    }
}
