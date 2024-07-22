package com.anbu.jersey;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

@Provider
public class Filter implements ContainerResponseFilter {


	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		
		if(requestContext.getMethod().equals("OPTIONS")) {
			responseContext.getHeaders().add("Access-Control-Allow-Origin", "*");
			responseContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
			responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
			responseContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		}
		
		
		String data =  responseContext.getEntity().toString() ;
		MessageDigest digester;
		
		try {
			digester = MessageDigest.getInstance("SHA-256");
			digester.update(data.getBytes());
			String checkSUm = Base64.getEncoder().encodeToString(digester.digest());
			responseContext.getHeaders().add("content-SHA256", checkSUm);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}

