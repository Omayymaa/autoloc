package tn.esprit.autoloc.autolocapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Reservation;
import tn.esprit.autoloc.autolocapi.service.IReservationService;

import java.util.List;

@Tag(name = "Gestion de reservations",description = "Crud")
@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {
    private final IReservationService reservationService;

    @Operation(summary = "récupérer toutes les réservation de la base de données")
    @GetMapping("/afficherToutesReservations")
    public List<Reservation> getAllReservations() {
        return reservationService.afficherToutesReservation();
    }

    @Operation(summary = "récupérer le réservation selon l'id donnée")
    @GetMapping("/afficherReservationById/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.afficherReservationById(id);
    }

    @Operation(summary = "ajouter une réservation")
    @PostMapping("/ajouterReservation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @Operation(summary = "modifier une reservation")
    @PutMapping("/modifierReservation")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @Operation(summary = "supprimer une reservation")
    @DeleteMapping("/supprimerReservation/{idReservation}")
    public void supprimerReservation(@PathVariable Long idReservation) {
        reservationService.supprimerReservation(idReservation);
    }
}