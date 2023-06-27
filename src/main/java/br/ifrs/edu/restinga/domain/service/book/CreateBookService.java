package br.ifrs.edu.restinga.domain.service.book;

import org.springframework.stereotype.Component;

import br.ifrs.edu.restinga.domain.dto.BookCreationData;
import br.ifrs.edu.restinga.domain.model.Book;
import br.ifrs.edu.restinga.jpa.BooksRepository;

@Component
public class CreateBookService {
    private BooksRepository repository;

    public CreateBookService(BooksRepository repository) {
        this.repository = repository;
    }

    public Book execute(BookCreationData bookData) {
        String title = bookData.getTitle();
        String name = bookData.getAuthorFirstName();
        String surname = bookData.getAuthorSecondName();
        String publishYear = bookData.getPublishYear();
        String publisher = bookData.getPublisher();
        boolean isDonation = bookData.getIsDonation();

        int year = Integer.parseInt(publishYear);
        
        boolean isTitleLengthValid = (title.length() > 10 && title.length() < 100);
        boolean isTitleValid = (title != null && title != "");
        boolean isNameValid = (name != null && name != "");
        boolean isPublisherValid = (publisher != null && publisher != "");
        boolean isYearValid = (year > 1800 && year < 2023);
        

        if (!isTitleValid || !isTitleLengthValid || !isNameValid || !isPublisherValid || !isYearValid)
            throw new Error("bad request");

        Book book = new Book();

        book.setTitle(title);
        book.setPublishYear(publishYear);
        book.setPublisher(publisher);
        book.setAuthorFirstName(name);
        book.setAuthorSecondName(surname);
        book.setDonation(isDonation);

        book = repository.save(book);

        return book;
    }
}
