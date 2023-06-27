package br.ifrs.edu.restinga.domain.service.client;

import org.springframework.stereotype.Component;

import br.ifrs.edu.restinga.domain.model.Client;
import br.ifrs.edu.restinga.jpa.ClientsRepository;

@Component
public class DeleteClientService {
    private ClientsRepository repository;

    public DeleteClientService(ClientsRepository repository) {
        this.repository = repository;
    }

    public void execute(int id) {
        Client client = new Client();
        client.setId(id);
        repository.delete(client);
    }
}
