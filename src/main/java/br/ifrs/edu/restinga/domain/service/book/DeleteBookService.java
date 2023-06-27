package br.ifrs.edu.restinga.domain.service.book;

import org.springframework.stereotype.Component;

import br.ifrs.edu.restinga.domain.model.Book;
import br.ifrs.edu.restinga.jpa.BooksRepository;

@Component
public class DeleteBookService {
    private BooksRepository repository;

    public DeleteBookService(BooksRepository repository) {
        this.repository = repository;
    }

    public void execute(int id) {
        Book book = new Book();
        book.setId(id);
        repository.delete(book);
    }
}
