package com.zilker.rest.AuthenticationRest;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;

import org.jose4j.jwk.PublicJsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.json.JSONObject;
import org.json.JSONTokener;

import io.jsonwebtoken.Header;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class ValidationDelegate {

	public String validateUser(String userName, String password) {
		// TODO Auto-generated method stub

		if (userName.equals("admin") && password.equals("1234")) {

			
			String jwt;
			try {
				jwt = Jwts.builder().setHeaderParam("typ", "JWT").setHeaderParam("alg", "HS256").setSubject(userName)
						.claim("name", userName).claim("scope","user") .setIssuer("server")
						.signWith(SignatureAlgorithm.HS256, "secret".getBytes("UTF-8")).compact();
				return jwt;
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

		}
		return "false";
	}

}
