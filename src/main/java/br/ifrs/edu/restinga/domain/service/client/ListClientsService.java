package br.ifrs.edu.restinga.domain.service.client;

import java.util.List;

import org.springframework.stereotype.Component;

import br.ifrs.edu.restinga.domain.model.Client;
import br.ifrs.edu.restinga.jpa.ClientsRepository;

@Component
public class ListClientsService {
    private ClientsRepository repository;

    public ListClientsService(ClientsRepository repository) {
        this.repository = repository;
    };

    public List<Client> execute() {
        List<Client> clients = repository.list();
        return clients;
    }

}
