package emsi.wafa_backend.services;

import emsi.wafa_backend.entities.OperationSAV;
import emsi.wafa_backend.entities.RAPOperation;
import emsi.wafa_backend.entities.RATOperation;
import emsi.wafa_backend.entities.Dossier;
import emsi.wafa_backend.repositories.OperationSAVRepository;
import emsi.wafa_backend.repositories.DossierRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OperationSAVServiceImpl implements OperationSAVService {

    private final OperationSAVRepository savRepo;
    private final DossierRepository dossierRepo;

    @Override
    public RAPOperation createRAP(Long dossierId, RAPOperation rap) {
        Dossier dossier = dossierRepo.findById(dossierId)
                .orElseThrow(() -> new EntityNotFoundException("Dossier " + dossierId + " introuvable"));
        rap.setDossier(dossier);
        return savRepo.save(rap);
    }

    @Override
    public RATOperation createRAT(Long dossierId, RATOperation rat) {
        Dossier dossier = dossierRepo.findById(dossierId)
                .orElseThrow(() -> new EntityNotFoundException("Dossier " + dossierId + " introuvable"));
        rat.setDossier(dossier);
        return savRepo.save(rat);
    }

    @Override
    @Transactional(readOnly = true)
    public OperationSAV get(Long id) {
        return savRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("OperationSAV " + id + " introuvable"));
    }

    @Override
    public void delete(Long id) { savRepo.deleteById(id); }

    @Override
    @Transactional(readOnly = true)
    public List<OperationSAV> listByDossier(Long dossierId) {
        return savRepo.findByDossierId(dossierId);
        // Variante via relation:
        // Dossier d = dossierRepo.findById(dossierId)
        //        .orElseThrow(() -> new EntityNotFoundException("Dossier " + dossierId + " introuvable"));
        // return d.getOperations();
    }
}
