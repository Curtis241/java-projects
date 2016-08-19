package ca.pragmaticdev.ws.controller;

import ca.pragmaticdev.ws.data.ServingImpl;
import ca.pragmaticdev.ws.data.User;
import ca.pragmaticdev.ws.data.UserImpl;
import ca.pragmaticdev.ws.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController {

    protected static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired(required = true)
    private UserService service;

    @CrossOrigin(origins = "http://calorietracker:8080")
    @RequestMapping(value= "/ws/users", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<User>> selectAll(@RequestParam(value="limit", defaultValue = "10") String limit) {

        service.setDailyIntakeLimit(Integer.parseInt(limit));
        return service.selectAll();
    }

    @CrossOrigin(origins = "http://calorietracker:8080")
    @RequestMapping(value= "/ws/user/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<User> select(@PathVariable(value="id") int id,@RequestParam(value="limit", defaultValue = "10") String limit) {

        service.setDailyIntakeLimit(Integer.parseInt(limit));
        return service.select(id);
    }

    @CrossOrigin(origins = "http://calorietracker:8080")
    @RequestMapping(value="/ws/register", method = RequestMethod.POST)
    public ResponseEntity<User> insert(@Valid @RequestBody UserImpl user) {

        return service.insert(user);
    }

    @CrossOrigin(origins = "http://calorietracker:8080")
    @RequestMapping(value="/ws/users", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@Valid @RequestBody UserImpl user) {

        return service.update(user);
    }

    @CrossOrigin(origins = "http://calorietracker:8080")
    @RequestMapping(value="/ws/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity remove(@PathVariable(value="id") int id) {

        return service.remove(id);
    }

    @CrossOrigin(origins = "http://calorietracker:8080")
    @RequestMapping(value="/ws/user/{id}/serving", method = RequestMethod.POST)
    public ResponseEntity<User> insertServing(@PathVariable(value="id") int id,
                                              @Valid @RequestBody ServingImpl serving,
                                              @RequestHeader("Authorization") String authorization) {

        return service.insertServing(id,serving);

    }

}
