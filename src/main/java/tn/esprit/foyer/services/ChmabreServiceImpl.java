package tn.esprit.foyer.services;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.foyer.entities.Bloc;
import tn.esprit.foyer.entities.Chambre;
import tn.esprit.foyer.entities.TypeChambre;
import tn.esprit.foyer.repositories.BlocRepository;
import tn.esprit.foyer.repositories.ChambreRepository;

import java.util.List;
@AllArgsConstructor
@Service
public class ChmabreServiceImpl implements IChambreService{
    @Autowired
    private BlocRepository blocRepository;
    @Autowired
    ChambreRepository chambreRepository;
    private static final Logger log = LoggerFactory.getLogger(ChmabreServiceImpl.class);


    @Override
    public Chambre addChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public Chambre getChambre(Long idChambre) {
        return chambreRepository.findById(idChambre).get();
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long idChambre) {
        chambreRepository.deleteById(idChambre);
    }

    @Override
    public List<Chambre> getAllChambre() {
        return (List<Chambre>) chambreRepository.findAll();
    }

    @Override
    public List<Chambre> addListChambre(List<Chambre> chambres) {
        return (List<Chambre>) chambreRepository.saveAll(chambres);
    }

    @Override
    public Chambre getChambreByNumeroChambre(long numeroChambre) {
        return chambreRepository.findByNumeroChambre(numeroChambre);
    }
    @Override
    @Scheduled(cron = "0 * * * * *")
    public void listeChambresParBloc() {
        List<Bloc> blocs = blocRepository.findAll();

        for (Bloc bloc : blocs) {
            log.info("Bloc => {} ayant une capacité {}", bloc.getNomBloc(), bloc.getCapaciteBloc());

            List<Chambre> chambres = chambreRepository.findByB(bloc);

            if (chambres.isEmpty()) {
                log.info("Pas de chambre disponible dans ce bloc");
            } else {
                log.info("La liste des chambres pour ce bloc:");
                for (Chambre chambre : chambres) {
                    log.info("NumChambre: {} type: {}", chambre.getNumeroChambre(), chambre.getTypeC());
                }
            }
            log.info("***********************");
        }
    }
    @Override
    @Scheduled(cron = "0 */5 * * * *")
    public void pourcentageChambreParTypeChambre() {
        List<Chambre> chambres = chambreRepository.findAll();
        int total = chambres.size();

        log.info(": Nombre total des chambre: {}", total);

        if (total > 0) {
            long simpleCount = chambres.stream().filter(c -> c.getTypeC() == TypeChambre.SIMPLE).count();
            long doubleCount = chambres.stream().filter(c -> c.getTypeC() == TypeChambre.DOUBLE).count();
            long tripleCount = chambres.stream().filter(c -> c.getTypeC() == TypeChambre.TRIPLE).count();

            double simplePct = (simpleCount * 100.0) / total;
            double doublePct = (doubleCount * 100.0) / total;
            double triplePct = (tripleCount * 100.0) / total;

            log.info(": Le pourcentage des chambres pour le type SIMPLE est égale à {}", simplePct);
            log.info(": Le pourcentage des chambres pour le type DOUBLE est égale à {}", doublePct);
            log.info(": Le pourcentage des chambres pour le type TRIPLE est égale à {}", triplePct);
        }
    }
    @Override
    @Scheduled(cron = "0 */5 * * * *")
    public void nbPlacesDisponibleParChambreAnneeEnCours() {
        List<Chambre> chambres = chambreRepository.findAllWithReservations();


        for (Chambre chambre : chambres) {
            int capacite = chambre.getCapacite();
            int nbOccupes = chambre.getReservations() != null ? chambre.getReservations().size() : 0;

            int nbDisponibles = capacite - nbOccupes;

            if (nbOccupes == 0) {
                log.info(": La chambre {} {} n'a aucune réservation, places disponibles = {}",
                        chambre.getTypeC(), chambre.getNumeroChambre(), capacite);
            } else if (nbDisponibles <= 0) {
                log.info(": La chambre {} {} est complète", chambre.getTypeC(), chambre.getNumeroChambre());
            } else {
                log.info(": Le nombre de place disponible pour la chambre {} {} est {}",
                        chambre.getTypeC(), chambre.getNumeroChambre(), nbDisponibles);
            }

        }
    }


}
