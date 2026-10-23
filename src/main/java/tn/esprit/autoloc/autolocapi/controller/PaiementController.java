package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Paiement;
import tn.esprit.autoloc.autolocapi.service.IPaiementService;

import java.util.List;

@Tag(name = "Gestion de paiements",description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/paiements")
public class PaiementController {
    private final IPaiementService paiementService;

    @Operation(summary = "récupérer tous les paiements de la base de données")
    @GetMapping("/afficherTousPaiements")
    public List<Paiement> getAllPaiements() {
        return paiementService.afficherTousPaiement();
    }

    @Operation(summary = "récupérer le paiement selon l'id donnée")
    @GetMapping("/afficherPaiementById/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.afficherPaiementById(id);
    }

    @Operation(summary = "ajouter un paiement")
    @PostMapping("/ajouterPaiement")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @Operation(summary = "modifier le paiement")
    @PutMapping("/modifierPaiement")
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @Operation(summary = "supprimer le paiement")
    @DeleteMapping("/supprimerPaiement/{idPaiement}")
    public void supprimerPaiement(@PathVariable Long idPaiement) {
        paiementService.supprimerPaiement(idPaiement);
    }
}