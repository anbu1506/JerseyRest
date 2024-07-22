package controllers;


import java.util.List;
import java.util.Optional;
import org.glassfish.jersey.media.multipart.FormDataParam;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;
import models.Author;
import models.Book;
import services.AuthorService;
import services.BookService;
import utils.ResponseMessage;

@Path("author")
public class AuthorController {
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	@Inject
	private BookService bookService;
	@Inject
	private AuthorService authorService ;
		
	@POST
	@Path("/{author_id}/addBook")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addBook(
			 @FormDataParam("book_id") int bookId,
			 @FormDataParam("isbn") String isbn,
			 @FormDataParam("genre") String genre,
			 @FormDataParam("title") String title,
			 @FormDataParam("publication_date") String publicationDate,
			 @PathParam("author_id") int authorId
			 ) throws JsonProcessingException
	{
		
		Optional<Author> a = authorService.getAuthorById(authorId);
		
		if(a.isEmpty()) {
			return Response.status(Status.NOT_FOUND).entity(new ResponseMessage("Author not Found", false)).build();
		}
		
		Book book = new Book(bookId,title,isbn,publicationDate,genre,authorId);
		boolean success = bookService.addBook(book);
		System.out.println(book);
		if(!success) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(new ResponseMessage("Failed to add book (Internal Server Error)", false)).build();
		}
		return Response.ok(new ResponseMessage("Book added successfully", true)).build();
	}

	
	@GET
	@Path("/{author_id}/getBooks")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllBooksByAuthor(@PathParam("author_id") int authorId) throws JsonProcessingException {
		
		Optional<Author> a = authorService.getAuthorById(authorId);
		
		if(a.isEmpty()) {
			return Response.status(Status.NOT_FOUND).entity(new ResponseMessage("Author not found", false)).build();
		}
		
		List<Book> books =  bookService.getBooksByAuthorId(authorId);
		System.out.println(books);
		return Response.ok(books).build();
	}
	
	@POST
	@Path("addAuthor")
	@Produces(MediaType.APPLICATION_JSON)
	public String addAuthor() throws JsonProcessingException {
		boolean success = authorService.addAuthor(new Author(1,"Anbu","Arasu","15/03/2001"));
		if(!success) {
			return objectMapper.writeValueAsString(new ResponseMessage("Author not added", success));
		}
		return objectMapper.writeValueAsString(new ResponseMessage("Author Added Successfully",true));
	}

	
	
//	@POST
//	@Path("/{author_id}/addBook")
//	@Consumes(MediaType.MULTIPART_FORM_DATA)
//	@Produces(MediaType.APPLICATION_JSON)
//	public String addBook(
//			 @FormDataParam("book_id") int bookId,
//			 @FormDataParam("isbn") String isbn,
//			 @FormDataParam("genre") String genre,
//			 @FormDataParam("title") String title,
//			 @FormDataParam("publication_date") String publicationDate,
//			 @PathParam("author_id") int authorId
//			 ) throws JsonProcessingException
//	{
//		Optional<Author> a = authorService.getAuthorById(authorId);
//		
//		if(a.isEmpty()) {
//			return objectMapper.writeValueAsString(new ResponseMessage("Author not added", false));
//		}
//		
//		Book book = new Book(bookId,title,isbn,publicationDate,genre,authorId);
//		boolean success = bookService.addBook(book);
//		System.out.println(book);
//		if(!success) {
//			return objectMapper.writeValueAsString(new ResponseMessage("Failed to add book (Internal Server Error)", false));
//		}
//		return objectMapper.writeValueAsString(new ResponseMessage("Book added successfully", true));
//	}
}
