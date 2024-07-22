package interceptors;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;


@TextIntercept
public class TextInterceptor implements ReaderInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		InputStream is = context.getInputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String body = br.lines().collect(Collectors.joining("\n"));
		context.setInputStream(new ByteArrayInputStream((body+" intercepted and modified 👾").getBytes()));
		return context.proceed();
	}

}
