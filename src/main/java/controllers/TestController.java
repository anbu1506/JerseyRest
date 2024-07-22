package controllers;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataParam;
import org.glassfish.jersey.server.ContainerRequest;

import interceptors.FileIntercept;
import interceptors.TextIntercept;
import interceptors.ContentNegotiate;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("file")

public class TestController {
	
	@GET
	@ContentNegotiate
	public Response getFile() throws FileNotFoundException {
		File f = new File("/home/anbarasu-si2783/Desktop/ex3.png");
		return Response.ok(new FileInputStream(f),"image/png").build();
	}
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.TEXT_PLAIN)
	@FileIntercept
	public String postFile(@FormDataParam("file") InputStream is) throws IOException {

		return "file received";
	}
	
	@Path("intercept")
	@POST
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	@TextIntercept
	public String intercept(@Context ContainerRequest req) {
		String body = req.readEntity(String.class);
		System.out.println(body);
		return body;
	}

}


