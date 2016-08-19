package ca.pragmaticdev.ws.controller;

import ca.pragmaticdev.ws.service.UserService;
import org.jboss.resteasy.spi.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@RestController
public class MainController {

    @Context
    HttpResponse response;

    @Autowired(required = true)
    private UserService service;

    @GET
    @Path("data")
    @Produces("application/json")
    public Response getUser(@QueryParam("username") String username) {
        return service.getUser(username);
    }
}
