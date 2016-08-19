package ca.pragmaticdev.ws.service;

import ca.pragmaticdev.ws.data.*;
import ca.pragmaticdev.ws.data.mapper.AuthenticationMapper;
import ca.pragmaticdev.ws.data.mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Created by cpeterson on 16/03/16.
 */
@Service
public class AuthenticationService implements UserDetailsService {

    protected static Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired(required = true)
    private AuthenticationMapper authenticationMapper;

    public ResponseEntity<Authorization> authenticate(String username, String password) {

      if(username.isEmpty() && password.isEmpty()) {
            throw new InvalidUserException();
      }

        UserCredentials user = authenticationMapper.SelectByName(username);

        if(user == null) throw new UserNotFoundException();

        String decodedPassword = new String(Base64.decodeBase64
                (user.getPassword().getBytes(Charset.forName("US-ASCII"))));

        if(password.matches(decodedPassword)) {

            String authorizationString = username + ":" + password;
            String basic = new String(Base64.encodeBase64
                    (authorizationString.getBytes(Charset.forName("US-ASCII"))));

            AuthorizationImpl authorization = new AuthorizationImpl("Basic " + basic);
            return new ResponseEntity<Authorization>(authorization, HttpStatus.ACCEPTED);

        } else {
            return new ResponseEntity<Authorization>(new AuthorizationImpl(null), HttpStatus.UNAUTHORIZED);
        }

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserCredentials user = authenticationMapper.SelectByName(username);
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());

        String decodedPassword = new String(Base64.decodeBase64
                (user.getPassword().getBytes(Charset.forName("US-ASCII"))));

        return new User(user.getUsername(),decodedPassword, Arrays.asList(authority));
    }
}
