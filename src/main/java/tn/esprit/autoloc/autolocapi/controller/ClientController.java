package tn.esprit.autoloc.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Client;
import tn.esprit.autoloc.autolocapi.service.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final IClientService clientService;

    @GetMapping("/afficherTousClients")
    public List<Client> getAllClients() {
        return clientService.afficherTousClient();
    }

    @GetMapping("/afficherClientById/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.afficherClientById(id);
    }

    @PostMapping("/ajouterClient")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @PutMapping("/modifierClient")
    public Client modifierClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @DeleteMapping("/supprimerClient/{idClient}")
    public void supprimerClient(@PathVariable Long idClient) {
        clientService.supprimerClient(idClient);
    }
}