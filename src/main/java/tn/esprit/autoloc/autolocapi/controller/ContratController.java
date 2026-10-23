package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Contrat;
import tn.esprit.autoloc.autolocapi.service.IContratService;

import java.util.List;

@Tag(name = "Gestion de contrats",description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/contrats")
public class ContratController {
    private final IContratService contratService;

    @Operation(summary = "récupérer toutes les contrats de la base de données")
    @GetMapping("/afficherTousContrats")
    public List<Contrat> getAllContrats() {
        return contratService.afficherTousContrat();
    }

    @Operation(summary = "récupérer le contrat selon l'id donnée")
    @GetMapping("/afficherContratById/{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return contratService.afficherContratById(id);
    }

    @Operation(summary = "ajouter un contrat")
    @PostMapping("/ajouterContrat")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @Operation(summary = "modifier un contrat")
    @PutMapping("/modifierContrat")
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @Operation(summary = "supprimer un contrat")
    @DeleteMapping("/supprimerContrat/{idContrat}")
    public void supprimerContrat(@PathVariable Long idContrat) {
        contratService.supprimerContrat(idContrat);
    }
}