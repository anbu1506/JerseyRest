package controllers;


import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import exceptions.InvalidIsbnException;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import models.Book;
import services.BookService;
import utils.ResponseMessage;

@Path("books/{isbn}")
public class BookController {
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Inject
	private BookService bookService;
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookByIsbn(@PathParam("isbn") String isbn) throws JsonProcessingException {
        Optional<Book> book = bookService.getBookByIsbn(isbn);
        if(book.isPresent()) {
        	System.out.println(book);
        	return Response.ok(book.get()).build();
        }
        throw new InvalidIsbnException();
    }
	
	@DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteBookByIsbn(@PathParam("isbn") String isbn) throws JsonProcessingException {
        boolean isDeleted = bookService.deleteBookByIsbn(isbn);
        if (isDeleted) {
            return objectMapper.writeValueAsString(new ResponseMessage("Book deleted successfully", true));
        } else {
            return objectMapper.writeValueAsString(new ResponseMessage("Book not found", false));
        }
    }
	

}

