package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Employe;
import tn.esprit.autoloc.autolocapi.service.IEmployeService;

import java.util.List;

@Tag(name = "Gestion d'employées",description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/employes")
public class EmployeController {
    private final IEmployeService employeService;

    @Operation(summary = "récupérer toutes les employées de la base de données")
    @GetMapping("/afficherTousEmployes")
    public List<Employe> getAllEmployes() {
        return employeService.afficherTousEmploye();
    }

    @Operation(summary = "récupérer l'employé selon l'id donnée")
    @GetMapping("/afficherEmployeById/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return employeService.afficherEmployeById(id);
    }

    @Operation(summary = "ajouter un employé")
    @PostMapping("/ajouterEmploye")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @Operation(summary = "modifier un employé")
    @PutMapping("/modifierEmploye")
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @Operation(summary = "supprimer un employé")
    @DeleteMapping("/supprimerEmploye/{idEmploye}")
    public void supprimerEmploye(@PathVariable Long idEmploye) {
        employeService.supprimerEmploye(idEmploye);
    }
}