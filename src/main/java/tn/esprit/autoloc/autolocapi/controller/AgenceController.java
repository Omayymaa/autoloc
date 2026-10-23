package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Agence;
import tn.esprit.autoloc.autolocapi.service.IAgenceService;

import java.util.List;

@Tag(name = "Gestion des agences",description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/agences")
public class AgenceController {
    private final IAgenceService agenceService;

    @Operation(summary = "récupérer toutes les agence de la base de données")
    @GetMapping("/afficherToutesAgences")
    public List<Agence> getAllAgences() {
        return agenceService.afficherToutesAgence();
    }

    @Operation(summary = "récupérer l'agence selon l'id donnée")
    @GetMapping("afficherAgenceById/{id}")
    public Agence getAgenceById(@PathVariable Long id) {
        return agenceService.afficherAgenceById(id);
    }

    @Operation(summary = "ajouter une agence")
    @PostMapping("/ajouterAgence")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }

    @Operation(summary = "modifier une agence")
    @PutMapping("/modifierAgence")
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }

    @Operation(summary = "supprimer une agence")
    @DeleteMapping("/supprimerAgence/{idAgence}")
    public void supprimerAgence(@PathVariable  Long idAgence) {
        agenceService.supprimerAgence(idAgence);
    }
}
