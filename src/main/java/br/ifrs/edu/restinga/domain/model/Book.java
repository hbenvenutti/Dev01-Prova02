package br.ifrs.edu.restinga.domain.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String authorFirstName;
    private String authorSecondName;
    private String publishYear;
    private String publisher;
    private boolean isDonation;

    // ------------------------------------------------------------------------------------------------------ //

    // public Book(int id, String title, String authorFirstName, String authorSecondName, String publishYear,
    //         String publisher, boolean isDonation) {
    //     this.id = id;
    //     this.title = title;
    //     this.authorFirstName = authorFirstName;
    //     this.authorSecondName = authorSecondName;
    //     this.publishYear = publishYear;
    //     this.publisher = publisher;
    //     this.isDonation = isDonation;
    // }

    // ----------------------------------------------------------------------------------------------------- //

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorSecondName() {
        return authorSecondName;
    }

    public void setAuthorSecondName(String authorSecondName) {
        this.authorSecondName = authorSecondName;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean getIsDonation() {
        return isDonation;
    }

    public void setDonation(boolean isDonation) {
        this.isDonation = isDonation;
    }

    // --------------------------------------------------------------------------------- //
    
    @Override
	public int hashCode() {
		return Objects.hash(id);
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return id == other.id;
	}
}
