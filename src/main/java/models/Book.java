package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Book {
	@JsonProperty("book_id")
    private int bookId;
	
	
    private String isbn;
    private String title;
    
    @JsonProperty("publication_date")
    private String publicationDate;
    
    private String genre;
    
    @JsonProperty("author_id") 
    private int authorId;

    @JsonCreator
    public Book(@JsonProperty("book_id") int bookId,
                @JsonProperty("title") String title,
                @JsonProperty("isbn") String isbn,
                @JsonProperty("publication_date") String publicationDate,
                @JsonProperty("genre") String genre,
                @JsonProperty("author_id") int authorId) {
        this.bookId = bookId;
        this.title = title;
        this.publicationDate = publicationDate;
        this.genre = genre;
        this.authorId = authorId;
        this.isbn = isbn;
    }
    
    public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public String getGenre() {
        return genre;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }


	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", isbn=" + isbn + ", title=" + title + ", publicationDate=" + publicationDate
				+ ", genre=" + genre + ", authorId=" + authorId + "]";
	}
    
    
}
