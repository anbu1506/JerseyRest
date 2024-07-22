package interceptors;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPOutputStream;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response.Status;
import jakarta.ws.rs.ext.WriterInterceptor;
import jakarta.ws.rs.ext.WriterInterceptorContext;

@ContentNegotiate
public class ContentNegotiator implements WriterInterceptor , ContainerResponseFilter {

	@Override
	public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
		String a =(String) context.getHeaders().getFirst(HttpHeaders.CONTENT_ENCODING);
		if(a!=null && a.equals("gzip")) {
			final OutputStream os = context.getOutputStream();
			context.setOutputStream(new GZIPOutputStream(os));
		}
		context.proceed();
		System.out.println(a);
	}

	@Override
	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
			throws IOException {
		List<String> acceptedEncodings = requestContext.getHeaders().get(HttpHeaders.ACCEPT_ENCODING);
		System.out.println(acceptedEncodings);
		List<String> newList = new ArrayList<String>();
		for(String i:acceptedEncodings) {
			String[] arr = i.split(", ");
			for(String j: arr) {
				newList.add(j);
			}
		}
		if(newList.contains("gzip")) {
			responseContext.getHeaders().add(HttpHeaders.CONTENT_ENCODING, "gzip");		}
		else {
			throw new WebApplicationException(Status.NOT_ACCEPTABLE);
		}
		
		
	}

}


