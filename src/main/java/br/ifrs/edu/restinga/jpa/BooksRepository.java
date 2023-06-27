package br.ifrs.edu.restinga.jpa;

import java.util.List;

import org.springframework.stereotype.Component;

import br.ifrs.edu.restinga.domain.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class BooksRepository {
    @PersistenceContext
    private EntityManager manager;

    public List<Book> list(){
        TypedQuery<Book> query = 
            manager.createQuery("from Book", Book.class);
        
        return query.getResultList();
    }

    @Transactional
	public Book save(Book book) {
        // create and update;
		return manager.merge(book);
	}

    public Book findById(int id) {
		return manager.find(Book.class, id);
	}

    @Transactional
	public void delete(Book book) {
		//find 
		 book = findById(book.getId());
		 manager.remove(book);
	}
}
