package ca.pragmaticdev.ws.service;

/**
 * Created by cpeterson on 14/04/16.
 */
public class Password {

    public Boolean encoded;
    public String password;

    public Password(String password,Boolean encoded) {
        this.encoded = encoded;
        this.password = password;
    }
}
