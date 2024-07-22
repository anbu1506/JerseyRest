package utils;

import org.glassfish.jersey.inject.hk2.AbstractBinder;

import services.AuthorService;
import services.BookService;

public class MyApplicationBinder extends AbstractBinder {
    @Override
    protected void configure() {
        bind(AuthorService.class).to(AuthorService.class);
        bind(BookService.class).to(BookService.class);
    }
}