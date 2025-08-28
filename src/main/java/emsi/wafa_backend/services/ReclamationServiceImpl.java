package emsi.wafa_backend.services;

import emsi.wafa_backend.entities.Client;
import emsi.wafa_backend.entities.Reclamation;
import emsi.wafa_backend.repositories.ClientRepository;
import emsi.wafa_backend.repositories.ReclamationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReclamationServiceImpl implements ReclamationService {

    private final ReclamationRepository reclamationRepo;
    private final ClientRepository clientRepo;

    @Override
    public Reclamation create(Long clientId, Reclamation r) {
        Client client = clientRepo.findById(clientId)
                .orElseThrow(() -> new EntityNotFoundException("Client " + clientId + " introuvable"));
        r.setClient(client);
        return reclamationRepo.save(r);
    }

    @Override
    public Reclamation update(Long id, Reclamation r) {
        Reclamation db = reclamationRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reclamation " + id + " introuvable"));
        db.setSujet(r.getSujet());
        db.setDescription(r.getDescription());
        return reclamationRepo.save(db);
    }

    @Override
    public void delete(Long id) { reclamationRepo.deleteById(id); }

    @Override
    @Transactional(readOnly = true)
    public Reclamation get(Long id) {
        return reclamationRepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Reclamation " + id + " introuvable"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reclamation> list() { return reclamationRepo.findAll(); }

    @Override
    @Transactional(readOnly = true)
    public List<Reclamation> listByClient(Long clientId) {
        return reclamationRepo.findByClientId(clientId);

        // Variante relationnelle (si tu as Client.getReclamations()):
        // Client c = clientRepo.findById(clientId)
        //         .orElseThrow(() -> new EntityNotFoundException("Client " + clientId + " introuvable"));
        // return c.getReclamations();
    }
}
