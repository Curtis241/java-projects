package ca.pragmaticdev.ws.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by cpeterson on 05/03/16.
 */
@ResponseStatus(value= HttpStatus.UNPROCESSABLE_ENTITY, reason="Provided serving is invalid")
public class InvalidServingException extends RuntimeException {

}
