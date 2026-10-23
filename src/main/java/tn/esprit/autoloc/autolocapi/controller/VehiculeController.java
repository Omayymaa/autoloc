package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Vehicule;
import tn.esprit.autoloc.autolocapi.service.IVehiculeService;

import java.util.List;

@Tag(name = "Gestion de vehicules",description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/vehicules")
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @Operation(summary = "récupérer tous les contrats de la base de données")
    @GetMapping("/afficherTousVehicules")
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.afficherTousVehicule();
    }

    @Operation(summary = "récupérer le vehicule selon l'id donnée")
    @GetMapping("/afficherVehiculeById/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return vehiculeService.afficherVehiculeById(id);
    }

    @Operation(summary = "ajouter un vehicule")
    @PostMapping("/ajouterVehicule")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @Operation(summary = "modifier un vehicule")
    @PutMapping("/modifierVehicule")
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @Operation(summary = "supprimer un vehicule")
    @DeleteMapping("/supprimerVehicule/{idVehicule}")
    public void supprimerVehicule(@PathVariable Long idVehicule) {
        vehiculeService.supprimerVehicule(idVehicule);
    }
}