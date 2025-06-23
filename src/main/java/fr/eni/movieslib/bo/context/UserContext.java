package fr.eni.movieslib.bo.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class UserContext {
    private String username = null;

    public UserContext(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return username;
    }

    public boolean isAdmin(){
        return true;
    }

}
