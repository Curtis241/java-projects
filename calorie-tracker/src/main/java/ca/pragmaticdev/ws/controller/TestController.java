package ca.pragmaticdev.ws.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

@Controller
@Path("/ws")
public class TestController {

    @GET
    @Path("test")
    public Response getTestResponse(){
        return Response.status(200).entity("Test Successful").build();
    }


}
