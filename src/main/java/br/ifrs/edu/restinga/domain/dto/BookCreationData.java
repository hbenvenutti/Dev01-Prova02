package br.ifrs.edu.restinga.domain.dto;

public class BookCreationData {
    private String title;
    private String authorFirstName;
    private String authorSecondName;
    private String publishYear;
    private String publisher;
    private boolean isDonation;
    
    public BookCreationData(String title, String authorFirstName, String authorSecondName, String publishYear,
            String publisher, boolean isDonation) {
        this.title = title;
        this.authorFirstName = authorFirstName;
        this.authorSecondName = authorSecondName;
        this.publishYear = publishYear;
        this.publisher = publisher;
        this.isDonation = isDonation;
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
}
