package br.ifrs.edu.restinga.domain.service.client;

import org.springframework.stereotype.Component;

import br.ifrs.edu.restinga.domain.dto.ClientCreationData;
import br.ifrs.edu.restinga.domain.model.Client;
import br.ifrs.edu.restinga.jpa.ClientsRepository;

@Component
public class CreateClientService {
    private ClientsRepository repository;

    public CreateClientService(ClientsRepository repository) {
        this.repository = repository;
    }

    public Client execute(ClientCreationData clientData) {
        String name = clientData.getName();
        String cpf = clientData.getCpf();
        String email = clientData.getEmail();
        String[] phones = clientData.getPhones();

        boolean isCpfValid = Client.isCpfValid(cpf);
        boolean isEmailValid = (email != null && email != "");
        boolean isNameValid = (name != null && name != "");
        boolean isPhonesValid = (phones != null && phones.length >= 0);
        boolean isCpfUsed = (repository.findByCpf(cpf).size() > 0);
        boolean isPhonesLengthValid = phones.length < 3;
        boolean isPhoneRepeated = Client.isPhoneRepeated(phones);

        if (isCpfUsed || !isPhonesLengthValid ||  !isCpfValid || !isNameValid || !isEmailValid || isPhoneRepeated || !isPhonesValid)
            throw new Error("bad request");

        Client client = new Client();

        client.setName(name);
        client.setCpf(cpf);
        client.setPhones(phones);;
        client.setEmail(email);

        client = repository.save(client);

        return client;
    }
}
