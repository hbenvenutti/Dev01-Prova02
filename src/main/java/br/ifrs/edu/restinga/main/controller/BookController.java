package br.ifrs.edu.restinga.main.controller;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ifrs.edu.restinga.domain.dto.BookCreationData;
import br.ifrs.edu.restinga.domain.model.Book;
import br.ifrs.edu.restinga.domain.service.book.CreateBookService;
import br.ifrs.edu.restinga.domain.service.book.DeleteBookService;
import br.ifrs.edu.restinga.domain.service.book.FindBookService;
import br.ifrs.edu.restinga.domain.service.book.ListBooksService;
import br.ifrs.edu.restinga.domain.service.book.UpdateBookService;

@Controller
@Component
public class BookController {
    ListBooksService listService;
    CreateBookService createService;
    FindBookService findService;
    UpdateBookService updateService;
    DeleteBookService deleteService;

    public BookController(ListBooksService listService, CreateBookService createService, 
        FindBookService findService, UpdateBookService updateService, 
        DeleteBookService deleteService) {
        this.listService = listService;
        this.createService = createService;
        this.updateService = updateService;
        this.findService = findService;
        this.deleteService = deleteService;
    }

    @GetMapping("/books")
    @ResponseBody
    public String listBooks() {
        List<Book> books = listService.execute();
        String response = "";
        
        for (Book book : books) {
            response += book.getId() + "\n"
            + book.getTitle() + "\n"
            + book.getAuthorFirstName() + "\n"
            + book.getAuthorSecondName() + "\n"
            + book.getPublishYear() + "\n"
            + book.getPublisher() + "\n"
            + book.getIsDonation() + "\n\n";
        }

        return response;
    }

    @GetMapping("/books/{id}")
    @ResponseBody
    public String getBook(@PathVariable int id) {
        Book book = findService.execute(id);

        String response = + book.getId() + "\n"
        + book.getTitle() + "\n"
        + book.getAuthorFirstName() + "\n"
        + book.getAuthorSecondName() + "\n"
        + book.getPublishYear() + "\n"
        + book.getPublisher() + "\n"
        + book.getIsDonation() + "\n";

        return response;
    }

    @PostMapping("/books")
    @ResponseBody
    public String createBook(@RequestBody BookCreationData data) {

        try {
            Book book = createService.execute(data);
            String response = + book.getId() + "\n"
            + book.getTitle() + "\n"
            + book.getAuthorFirstName() + "\n"
            + book.getAuthorSecondName() + "\n"
            + book.getPublishYear() + "\n"
            + book.getPublisher() + "\n"
            + book.getIsDonation() + "\n";
            
            return response;
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @DeleteMapping("/books/{id}")
    @ResponseBody
    public void deleteBook(@PathVariable int id) {

        deleteService.execute(id);
    }

    @PutMapping("/books/{id}")
    @ResponseBody
    public String updateBook(@PathVariable int id, @RequestBody BookCreationData data) {

        try {
            Book book = updateService.execute(id, data);

            String response = + book.getId() + "\n"
            + book.getTitle() + "\n"
            + book.getAuthorFirstName() + "\n"
            + book.getAuthorSecondName() + "\n"
            + book.getPublishYear() + "\n"
            + book.getPublisher() + "\n"
            + book.getIsDonation() + "\n";
            
            return response;

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
