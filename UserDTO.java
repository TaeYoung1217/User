package mission.User;

import java.io.Serializable;

public class UserDTO implements Serializable {
    private String username;
    private String role;

    public UserDTO(String username, String role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }
}
