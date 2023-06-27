package br.ifrs.edu.restinga.domain.service.book;

import org.springframework.stereotype.Component;

import br.ifrs.edu.restinga.domain.model.Book;
import br.ifrs.edu.restinga.jpa.BooksRepository;

@Component
public class FindBookService {
    private BooksRepository repository;

    public FindBookService(BooksRepository repository) {
        this.repository = repository;
    }

    public Book execute(int id) {
        Book book = repository.findById(id);

        return book;
    }
}
