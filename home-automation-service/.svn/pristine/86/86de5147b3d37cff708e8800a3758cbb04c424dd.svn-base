package org.sakila.ws.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.sakila.ws.controller.ResponseObject.STATUS;
import org.springframework.stereotype.Controller;

@Controller
@Path("/ws")
public class TestController {

	@GET
	@Path("test")
	public Response getTestResponse(){
		ResponseObject obj = new ResponseObject(STATUS.SUCCESS);
		return Response.status(200).entity(obj).build();
	}
}
