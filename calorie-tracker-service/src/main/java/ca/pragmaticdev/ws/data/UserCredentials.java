package ca.pragmaticdev.ws.data;

/**
 * Created by cpeterson on 09/04/16.
 */
public class UserCredentials  {

    private String username;
    private String password;
    private String role = "USER";

    public UserCredentials(String username,String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
}
