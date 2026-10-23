package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Client;
import tn.esprit.autoloc.autolocapi.service.IClientService;

import java.util.List;

@Tag(name = "Gestion de clients",description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/clients")
public class ClientController {
    private final IClientService clientService;

    @Operation(summary = "récupérer tous les clients de la base de données")
    @GetMapping("/afficherTousClients")
    public List<Client> getAllClients() {
        return clientService.afficherTousClient();
    }

    @Operation(summary = "récupérer le client selon l'id donnée")
    @GetMapping("/afficherClientById/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.afficherClientById(id);
    }

    @Operation(summary = "ajouter un client")
    @PostMapping("/ajouterClient")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @Operation(summary = "modifier un client")
    @PutMapping("/modifierClient")
    public Client modifierClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @Operation(summary = "supprimer un client")
    @DeleteMapping("/supprimerClient/{idClient}")
    public void supprimerClient(@PathVariable Long idClient) {
        clientService.supprimerClient(idClient);
    }
}