package ca.pragmaticdev.ws.data.mapper;

import ca.pragmaticdev.ws.data.User;
import ca.pragmaticdev.ws.data.UserCredentials;

import java.util.List;

public interface AuthenticationMapper {

    UserCredentials SelectByName(String username);

}
