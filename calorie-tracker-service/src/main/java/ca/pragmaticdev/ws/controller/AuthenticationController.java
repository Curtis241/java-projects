package ca.pragmaticdev.ws.controller;

import ca.pragmaticdev.ws.data.Authorization;
import ca.pragmaticdev.ws.service.AuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AuthenticationController {

    protected static Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired(required = true)
    private AuthenticationService service;

    @CrossOrigin(origins = "http://calorietracker")
    @RequestMapping(value= "/ws/authenticate", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Authorization> authenticate(@RequestParam("username") String username,
                                                      @RequestParam("password") String password) {

        return service.authenticate(username,password);
    }

}
