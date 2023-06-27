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

import br.ifrs.edu.restinga.domain.dto.ClientCreationData;
import br.ifrs.edu.restinga.domain.model.Client;
import br.ifrs.edu.restinga.domain.service.client.CreateClientService;
import br.ifrs.edu.restinga.domain.service.client.DeleteClientService;
import br.ifrs.edu.restinga.domain.service.client.FindClientService;
import br.ifrs.edu.restinga.domain.service.client.ListClientsService;
import br.ifrs.edu.restinga.domain.service.client.UpdateClientService;

@Controller
@Component
public class ClientController {
    ListClientsService listService;
    FindClientService findService;
    DeleteClientService deleteService;
    CreateClientService createService;
    UpdateClientService updateService;


    public ClientController(ListClientsService listService, FindClientService findService,
            DeleteClientService deleteService, CreateClientService createService, UpdateClientService updateService) {
        this.listService = listService;
        this.findService = findService;
        this.deleteService = deleteService;
        this.createService = createService;
        this.updateService = updateService;
    }

    @GetMapping("/clients")
    @ResponseBody
    public String listClients() {
        List<Client> clients = listService.execute();
        String response = "";

        for (Client client : clients) {
            String[] phones = client.getPhones();

            response += client.getName() + "\n"
            + client.getCpf() + "\n"
            + client.getEmail() + "\n"
            + phones[0] + "\n"
            + phones[1] + "\n"
            + "\n\n";
        }

        return response;
    }

    @GetMapping("/clients/{id}")
    @ResponseBody
    public String getClient(@PathVariable int id) {
        Client client = findService.execute(id);

        String[] phones = client.getPhones();

        String response = client.getName() + "\n" 
            + client.getCpf() + "\n" 
            + client.getEmail() + "\n"
            + phones[0] + "\n"
            + phones[1] + "\n";
        
        return response;
    }

    @DeleteMapping("/clients/{id}")
    @ResponseBody
    public void deleteClient(@PathVariable int id) {

        deleteService.execute(id);
    }

    @PostMapping("/clients")
    @ResponseBody
    public String createClient(@RequestBody ClientCreationData data) {

        try {
            Client client = createService.execute(data);
            String[] phones = client.getPhones();

            String response = client.getName() + "\n" 
                + client.getCpf() + "\n" 
                + client.getEmail() + "\n"
                + phones[0] + "\n"
                + phones[1] + "\n";
            
            return response;
            
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @PutMapping("/clients/{id}")
    @ResponseBody
    public String updateClient(@PathVariable int id, @RequestBody ClientCreationData data) {

        try {
            Client client = updateService.execute(id, data);
            String[] phones = client.getPhones();

            String response = client.getName() + "\n" 
                + client.getCpf() + "\n" 
                + client.getEmail() + "\n"
                + phones[0] + "\n"
                + phones[1] + "\n";
            
            return response;

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
