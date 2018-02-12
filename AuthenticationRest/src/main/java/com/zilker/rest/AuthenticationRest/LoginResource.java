package com.zilker.rest.AuthenticationRest;

import java.io.UnsupportedEncodingException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

@Path("/login")
public class LoginResource {

	@GET
	@Produces("text/plain")
	public Response check(@QueryParam("username") String userName, @QueryParam("password") String password) {
		ValidationDelegate valid = new ValidationDelegate();

		String jwt = "", responseString = "";
		Response response = null;
		jwt = valid.validateUser(userName, password);
		System.out.println("response jwt " + jwt);

		if (jwt.equals("false")) {
			response = Response.status(Status.UNAUTHORIZED).build();
		} else {
			response = Response.ok("in else").header("jwt", jwt).build();

		}
		System.out.println(response);
		return response;

	}
}
