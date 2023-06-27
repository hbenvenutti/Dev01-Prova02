package br.ifrs.edu.restinga.jpa;

import java.util.List;

import org.springframework.stereotype.Component;

import br.ifrs.edu.restinga.domain.model.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Component
public class ClientsRepository {
    @PersistenceContext
    private EntityManager manager;

    public List<Client> list(){
        TypedQuery<Client> query = 
            manager.createQuery("from Client", Client.class);
        
        return query.getResultList();
    }

    @Transactional
	public Client save(Client book) {
        // create and update;
		return manager.merge(book);
	}

    public Client findById(int id) {
		return manager.find(Client.class, id);
	}

    public List<Client> findByCpf(String cpf) {
        TypedQuery<Client> query = 
            manager.createQuery("from Client where cpf = " + cpf, Client.class);

		return query.getResultList();
	}

    @Transactional
	public void delete(Client book) {
		// find 
		 book = findById(book.getId());
		 manager.remove(book);
	}
}
