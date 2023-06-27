package br.ifrs.edu.restinga.domain.service.book;

import java.util.List;

import org.springframework.stereotype.Component;

import br.ifrs.edu.restinga.domain.model.Book;
import br.ifrs.edu.restinga.jpa.BooksRepository;

@Component
public class ListBooksService {
    private BooksRepository repository;

    public ListBooksService(BooksRepository repository) {
        this.repository = repository;
    };

    public List<Book> execute() {
        List<Book> books = repository.list();
        return books;
    }

}
