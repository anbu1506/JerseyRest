package com.anbu.jersey;

import org.glassfish.jersey.server.ResourceConfig;

import interceptors.ContentNegotiator;
import interceptors.FileInterceptor;
import interceptors.TextInterceptor;
import utils.MyApplicationBinder;


public class MyApplication extends ResourceConfig {
	
		public MyApplication() {
			packages(true,"controllers");
			register(new MyApplicationBinder());
			register(Filter.class);
			register(TextInterceptor.class);
			register(ContentNegotiator.class);
			register(FileInterceptor.class);
//			register(EncodingFilter.class);
//			register(GZipEncoder.class);
		}
}
