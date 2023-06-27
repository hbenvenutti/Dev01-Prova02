package br.ifrs.edu.restinga.domain.service.client;

import org.springframework.stereotype.Component;

import br.ifrs.edu.restinga.domain.model.Client;
import br.ifrs.edu.restinga.jpa.ClientsRepository;

@Component
public class FindClientService {
    private ClientsRepository repository;

    public FindClientService(ClientsRepository repository) {
        this.repository = repository;
    }

    public Client execute(int id) {
        Client client = repository.findById(id);

        return client;
    }
}
