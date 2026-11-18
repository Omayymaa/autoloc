package tn.esprit.autoloc.autolocapi.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.autolocapi.domain.Agence;
import tn.esprit.autoloc.autolocapi.domain.Equipement;
import tn.esprit.autoloc.autolocapi.domain.Vehicule;
import tn.esprit.autoloc.autolocapi.repository.AgenceRepository;
import tn.esprit.autoloc.autolocapi.repository.EquipementRepository;
import tn.esprit.autoloc.autolocapi.repository.VehiculeRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class IVehiculeServiceImp implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;
    private final AgenceRepository agenceRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> afficherTousVehicule() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule afficherVehiculeById(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }


    private final EquipementRepository equipementRepository; // à ajouter avec les autres champs

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();
        Equipement equipement = equipementRepository.findById(idEquipement).get();
        vehicule.getEquipements().add(equipement);
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule).get();
        vehicule.getEquipements().removeIf(e -> e.getIdEquipement().equals(idEquipement));
        return vehiculeRepository.save(vehicule);
    }


    @Scheduled(fixedRate = 60000 , initialDelay = 5000)
    public void actualiserEtatVehicule() {
        //Récupérer  tous les véhicules enregistrés
        List<Vehicule> vehicules = vehiculeRepository.findAll();

        System.out.println("\n Question 1 : Actualisation des vehicules");

        //Afficher le nombre total de véhiccules
        System.out.println("Nombre total de véhivules : " + vehicules.size());

        //Afficher la date et l'heure de l'actualisation
        System.out.println("Date d'actualisation : " + LocalDateTime.now());
    }


    // S'exécute 2 minutes (120000 ms) après la FIN de chaque exécution
    @Scheduled(fixedDelay = 120000)
    public void suivreNombreAgences() {
        // Récupérer la liste des agences enregistrées
        List<Agence> agences = agenceRepository.findAll();

        System.out.println("\n Question 2 : Suivi des agences");

        // Afficher le nombre total d'agences
        System.out.println("Nombre total d'agences : " + agences.size());

        // Afficher la date et l'heure de la vérification
        System.out.println("Date de vérification : " + LocalDateTime.now());
    }


    // Tous les lundis à 09h00
    @Scheduled(cron = "0 0 9 * * MON")
    public void genererRapportVehicules() {
        // Récupérer tous les véhicules enregistrés
        List<Vehicule> vehicules = vehiculeRepository.findAll();

        // Calculer le nombre total de véhicules
        int total = vehicules.size();

        // Afficher le rapport
        System.out.println("\n Question 3 : Rapport des véhicules");
        System.out.println("Nombre total de véhicules : " + total);
        System.out.println("Date de génération : " + LocalDateTime.now());
    }


}
