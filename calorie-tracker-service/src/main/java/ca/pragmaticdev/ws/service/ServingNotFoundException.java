package ca.pragmaticdev.ws.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by cpeterson on 15/02/16.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="There is no serving matching given dailyIntakeId")
public class ServingNotFoundException extends RuntimeException {
}
