package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Maintenance;
import tn.esprit.autoloc.autolocapi.service.IMaintenanceService;

import java.util.List;

@Tag(name = "Gestion de maintenances",description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/maintenances")
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @Operation(summary = "récupérer toutes les maintenances de la base de données")
    @GetMapping("/afficherToutesMaintenances")
    public List<Maintenance> getAllMaintenances() {
        return maintenanceService.afficherToutesMaintenance();
    }

    @Operation(summary = "récupérer le maintenance selon l'id donnée")
    @GetMapping("/afficherMaintenanceById/{id}")
    public Maintenance getMaintenanceById(@PathVariable Long id) {
        return maintenanceService.afficherMaintenanceById(id);
    }

    @Operation(summary = "ajouter maintenance")
    @PostMapping("/ajouterMaintenance")
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @Operation(summary = "modifier maintenance")
    @PutMapping("/modifierMaintenance")
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @Operation(summary = "supprimer maintenance")
    @DeleteMapping("/supprimerMaintenance/{idMaintenance}")
    public void supprimerMaintenance(@PathVariable Long idMaintenance) {
        maintenanceService.supprimerMaintenance(idMaintenance);
    }
}