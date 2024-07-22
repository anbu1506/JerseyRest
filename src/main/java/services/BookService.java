package services;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import jakarta.annotation.ManagedBean;
import models.Book;
import utils.DbConnection;

@ManagedBean
public class BookService {
	
	private Connection conn = DbConnection.getConnection();
	
	public boolean addBook(Book book) {
		boolean status = false;
		String query = "INSERT INTO Book (isbn,title,publish_date,genre,author_id) VALUES (?,?,?,?,?)";
		try {
			PreparedStatement preparedStatement = (PreparedStatement) conn.prepareStatement(query);
			preparedStatement.setString(1, book.getIsbn());
			preparedStatement.setString(2, book.getTitle());
			preparedStatement.setString(3, book.getPublicationDate());
			preparedStatement.setString(4, book.getGenre());
			preparedStatement.setInt(5, book.getAuthorId());
			
			status = preparedStatement.executeUpdate()!=0 ;
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	 public Optional<Book> getBookByIsbn(String isbn) {
		Optional<Book> book = Optional.empty();
		String query = "SELECT * FROM Book WHERE isbn = '"+ isbn+"'";
		try {
    		Statement st=(Statement) conn.createStatement();
    		ResultSet rs=st.executeQuery(query);
    		if(rs.next()) {
    			book = Optional.of(new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6)));
    		}
    		
		} catch (SQLException e) {
			System.out.println(e);
		}
		return book;
	 }
	
	 public boolean deleteBookByIsbn(String isbn) {
		 boolean status =false;
		 String query = "DELETE FROM Book WHERE isbn = ?";
		 try {
			 PreparedStatement st =  (PreparedStatement) conn.prepareStatement(query);
			 st.setString(1,isbn);
			 status = st.executeUpdate()!=0; 
		 }
		 catch(SQLException e) {
			 System.out.println(e);
		 }
		 return status;
	 }

	 public List<Book> getBooksByAuthorId(int id){
		 List<Book> books = new ArrayList<>();
		 String query = "SELECT * FROM Book WHERE author_id="+id;
			try {
	    		Statement st=(Statement) conn.createStatement();
	    		ResultSet rs=st.executeQuery(query);
	    		while(rs.next()) {
	    			Book book = new Book(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
		    		books.add(book);
	    		}
	    		
			} catch (SQLException e) {
				System.out.println(e);
			}
		 return books;
	 }
}
