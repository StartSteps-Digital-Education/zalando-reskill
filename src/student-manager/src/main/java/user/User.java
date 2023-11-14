package user;

import java.io.Serializable;

public class User implements Serializable {
    public String username;
    public String password;
    public UserRole role;

    public User(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }
}

