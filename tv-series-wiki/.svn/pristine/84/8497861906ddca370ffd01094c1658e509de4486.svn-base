package org.sakila.ws.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.sakila.ws.service.SearchResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@Path("/search")
public class SearchResultController {

protected static Logger logger = Logger.getLogger(DirectorController.class);
	
	@Autowired(required = true)
	private SearchResultService service;
	
	@GET
	@Path("episode/name/{name}")
	@Produces("application/json")
	public Response selectEpisodeByName(@PathParam("name") String name) {
		return service.selectByEpisodeName(name);
	}
	
	@GET
	@Path("episode/number/{number}")
	@Produces("application/json")
	public Response selectEpisodeByNumber(@PathParam("number") int number) {
		return service.selectByEpisodeNumber(number);
	}
	
	@GET
	@Path("genre/{genre}")
	@Produces("application/json")
	public Response selectGenreByName(@PathParam("genre") String name){
		return service.selectByGenreName(name);
	}
	
	@GET
	@Path("rating/{rating}")
	@Produces("application/json")
	public Response selectRatingByName(@PathParam("rating") String name) {
		return service.selectByRatingName(name);
	}
	
	@GET
	@Path("series/{series}")
	@Produces("application/json")
	public Response selectBySeriesName(@PathParam("series") String name) {
		return service.selectBySeriesName(name);
	}
	
	
	
	
}
