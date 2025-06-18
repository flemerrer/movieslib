package fr.eni.movieslib.bo.context;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private String username = null;

    public User(String username) {
        this.username = username;
    }

}
