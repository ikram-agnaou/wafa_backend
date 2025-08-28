package emsi.wafa_backend.services;

import emsi.wafa_backend.entities.Dossier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DossierService {
    Dossier create(Dossier d, Long clientId);
    Dossier update(Long id, Dossier d);
    void delete(Long id);
    Dossier get(Long id);
    List<Dossier> list();
    Page<Dossier> page(Pageable pageable);

    // seulement la signature ici
    List<Dossier> listByClient(Long clientId);
}
