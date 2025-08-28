package emsi.wafa_backend.services;

import emsi.wafa_backend.entities.Client;
import emsi.wafa_backend.entities.Dossier;
import emsi.wafa_backend.repositories.ClientRepository;
import emsi.wafa_backend.repositories.DossierRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class DossierServiceImpl implements DossierService {

    private final DossierRepository dossierRepo;
    private final ClientRepository clientRepo;

    @Override
    public Dossier create(Dossier d, Long clientId) {
        Client client = clientRepo.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client " + clientId + " introuvable"));
        d.setClient(client);
        return dossierRepo.save(d);
    }

    @Override
    public Dossier update(Long id, Dossier d) {
        Dossier db = dossierRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dossier " + id + " introuvable"));

        // Remets ici les champs à mettre à jour selon ton entité
        db.setMontant(d.getMontant());
        db.setDureeMois(d.getDureeMois());
        db.setTaux(d.getTaux());
        db.setDateDebut(d.getDateDebut());

        return dossierRepo.save(db);
    }

    @Override
    public void delete(Long id) { dossierRepo.deleteById(id); }

    @Override
    @Transactional(readOnly = true)
    public Dossier get(Long id) {
        return dossierRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Dossier " + id + " introuvable"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Dossier> list() { return dossierRepo.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public Page<Dossier> page(Pageable pageable) { return dossierRepo.findAll(pageable); }

    @Override
    @Transactional(readOnly = true)
    public List<Dossier> listByClient(Long clientId) {
        return dossierRepo.findByClientId(clientId);

        // Variante relationnelle si tu as Client.getDossiers()
        // Client client = clientRepo.findById(clientId)
        //         .orElseThrow(() -> new EntityNotFoundException("Client " + clientId + " introuvable"));
        // return client.getDossiers();
    }
}
