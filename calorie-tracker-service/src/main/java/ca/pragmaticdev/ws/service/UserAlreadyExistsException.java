package ca.pragmaticdev.ws.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by cpeterson on 15/02/16.
 */
@ResponseStatus(value= HttpStatus.CONFLICT, reason="User already exists and cannot be inserted again")
public class UserAlreadyExistsException extends RuntimeException {

}
