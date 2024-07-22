package interceptors;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;



@FileIntercept
public class FileInterceptor implements ReaderInterceptor {

	@Override
	public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
		InputStream is  = context.getInputStream();
		byte[] arr = is.readAllBytes();
		FileOutputStream fout = new FileOutputStream(new File("/home/anbarasu-si2783/Desktop/demo.txt"));
		fout.write(arr);
		fout.flush();
		fout.close();
		System.out.println(arr.length);
		System.out.println("The length of the file is "+arr.length);
		return context.proceed();
		}

}
