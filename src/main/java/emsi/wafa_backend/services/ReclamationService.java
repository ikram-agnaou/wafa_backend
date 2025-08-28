package emsi.wafa_backend.services;

import emsi.wafa_backend.entities.Reclamation;
import java.util.List;

public interface ReclamationService {
    Reclamation create(Long clientId, Reclamation r);
    Reclamation update(Long id, Reclamation r);
    void delete(Long id);
    Reclamation get(Long id);
    List<Reclamation> list();

    // seulement la signature ici
    List<Reclamation> listByClient(Long clientId);
}
