package emsi.wafa_backend.services;

import emsi.wafa_backend.entities.Dossier;
import emsi.wafa_backend.entities.Echeance;
import emsi.wafa_backend.exceptions.NotFoundException;
import emsi.wafa_backend.repositories.DossierRepository;
import emsi.wafa_backend.repositories.EcheanceRepository;
import emsi.wafa_backend.services.EcheanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional
public class EcheanceServiceImpl implements EcheanceService {
    private final EcheanceRepository echeanceRepo;
    private final DossierRepository dossierRepo;

    @Override public Echeance create(Long dossierId, Echeance e){
        Dossier dossier = dossierRepo.findById(dossierId).orElseThrow(() -> new NotFoundException("Dossier "+dossierId+" introuvable"));
        e.setDossier(dossier);
        return echeanceRepo.save(e);
    }

    @Override public Echeance update(Long id, Echeance e){
        Echeance db = echeanceRepo.findById(id).orElseThrow(() -> new NotFoundException("Echéance "+id+" introuvable"));
        db.setNumero(e.getNumero());
        db.setDate(e.getDate());
        db.setMontant(e.getMontant());
        db.setReste(e.getReste());
        return db;
    }

    @Override public void delete(Long id){ echeanceRepo.deleteById(id); }

    @Override @Transactional(readOnly = true)
    public Echeance get(Long id){ return echeanceRepo.findById(id).orElseThrow(() -> new NotFoundException("Echéance "+id+" introuvable")); }

    @Override @Transactional(readOnly = true)
    public List<Echeance> listByDossier(Long dossierId){
        Dossier dossier = dossierRepo.findById(dossierId).orElseThrow(() -> new NotFoundException("Dossier "+dossierId+" introuvable"));
        return dossier.getEcheances(); // idem remarque
    }
}
