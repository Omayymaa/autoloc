package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Equipement;
import tn.esprit.autoloc.autolocapi.service.IEquipementService;

import java.util.List;

@Tag(name = "Gestion d' equipements",description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/equipements")
public class EquipementController {
    private final IEquipementService equipementService;

    @Operation(summary = "récupérer toutes les equipements de la base de données")
    @GetMapping("/afficherTousEquipements")
    public List<Equipement> getAllEquipements() {
        return equipementService.afficherTousEquipement();
    }

    @Operation(summary = "récupérer l'equipement' selon l'id donnée")
    @GetMapping("/afficherEquipementById/{id}")
    public Equipement getEquipementById(@PathVariable Long id) {
        return equipementService.afficherEquipementById(id);
    }

    @Operation(summary = "ajouter un equipement")
    @PostMapping("/ajouterEquipement")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @Operation(summary = "modifier un equipement")
    @PutMapping("/modifierEquipement")
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @Operation(summary = "supprimer un equipement")
    @DeleteMapping("/supprimerEquipement/{idEquipement}")
    public void supprimerEquipement(@PathVariable Long idEquipement) {
        equipementService.supprimerEquipement(idEquipement);
    }
}