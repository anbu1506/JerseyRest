package models;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Author {
	@JsonProperty("author_id")
    private int authorId;
	@JsonProperty("first_name")
    private String firstName;
	@JsonProperty("last_name")
    private String lastName;
	@JsonProperty("date_of_birth")
    private String dateOfBirth;

    @JsonCreator
    public Author(@JsonProperty("author_id") int authorId,
                  @JsonProperty("first_name") String firstName,
                  @JsonProperty("last_name") String lastName,
                  @JsonProperty("date_of_birth") String dateOfBirth) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
