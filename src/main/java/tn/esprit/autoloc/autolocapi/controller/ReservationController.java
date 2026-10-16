package tn.esprit.autoloc.autolocapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.autolocapi.domain.Reservation;
import tn.esprit.autoloc.autolocapi.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
public class ReservationController {
    private final IReservationService reservationService;

    @GetMapping("/afficherToutesReservations")
    public List<Reservation> getAllReservations() {
        return reservationService.afficherToutesReservation();
    }

    @GetMapping("/afficherReservationById/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.afficherReservationById(id);
    }

    @PostMapping("/ajouterReservation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @PutMapping("/modifierReservation")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @DeleteMapping("/supprimerReservation/{idReservation}")
    public void supprimerReservation(@PathVariable Long idReservation) {
        reservationService.supprimerReservation(idReservation);
    }
}