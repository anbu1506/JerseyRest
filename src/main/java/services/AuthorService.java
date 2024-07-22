package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import jakarta.annotation.ManagedBean;
import models.Author;
import utils.DbConnection;

@ManagedBean
public class AuthorService {
    private Connection conn = DbConnection.getConnection();
    

    public boolean addAuthor(Author author) {
    	boolean status = false;
    	String query = "INSERT INTO author (first_name,dob,last_name) VALUES  (?,?,?)";
		try {
			PreparedStatement st=(PreparedStatement) conn.prepareStatement(query);
			st.setString(1,author.getFirstName());
			st.setString(2,author.getDateOfBirth());
			st.setString(3,author.getLastName());
			status = st.executeUpdate()!=0;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
    }

    public Optional<Author> getAuthorById(int authorId) {
    	Optional<Author> author = java.util.Optional.empty() ;
    	String query = "SELECT * FROM author WHERE id = "+authorId;
    	try {
    		Statement st=(Statement) conn.createStatement();
    		ResultSet rs=st.executeQuery(query);
    		if(rs.next()) {
    			author = Optional.of(new Author(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4)));
    		}
    		
		} catch (SQLException e) {
			
		}
        return author;
    }
    
}
