package com.zilker.rest.AuthenticationRest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.jose4j.jwt.consumer.InvalidJwtException;

import com.zilker.rest.AuthenticationRest.Secured;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Priority(Priorities.AUTHENTICATION)
@Provider
@Secured
public class JWTFilter implements ContainerRequestFilter {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		String authHeaderVal = requestContext.getHeaderString("Authorization");
		String check = "", token = "";
		try {
			if (authHeaderVal.startsWith("Bearer")) {
				System.out.println("in jwt filter");
				token = authHeaderVal.split(" ")[1];
				check = validate(token);
				if (check.equals("valid")) {
					System.out.println("in filter");
				} else {
					System.out.println("invalid token");
					requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
				}

			} else {
				System.out.println("invalid header");
				requestContext.setProperty("auth-failed", true);
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			}
		} catch (Exception e) {
			System.out.println("invalid header");
			requestContext.setProperty("auth-failed", true);
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}

	}

	public String validate(String jwt) {
		// TODO Auto-generated method stub

		try {
			Jws<Claims> claims = null;
			claims = Jwts.parser().setSigningKey("secret".getBytes("UTF-8")).parseClaimsJws(jwt);
			String scope = (String) claims.getBody().get("scope");
			if (scope.equals("user")) {
				return "valid";
			}

		} catch (ExpiredJwtException e) {
			// TODO Auto-generated catch block
			System.out.println("expired jwt");
		} catch (UnsupportedJwtException e) {
			// TODO Auto-generated catch block
			System.out.println("expired");
		} catch (MalformedJwtException e) {
			// TODO Auto-generated catch block
			System.out.println("malformed");
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			System.out.println("Signature Exception");
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			System.out.println("illegal arguments");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			System.out.println("unsupported encoding");
		}
		return "false";
	}
}
