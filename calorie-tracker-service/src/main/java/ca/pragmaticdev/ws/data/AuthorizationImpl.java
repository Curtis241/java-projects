package ca.pragmaticdev.ws.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by cpeterson on 17/03/16.
 */
public class AuthorizationImpl implements Authorization {

    @JsonProperty("hash")
    private String hash;

    public AuthorizationImpl(String hash) {
        this.hash = hash;
    }

    @Override
    public String getHash() {
        return this.hash;
    }
}
