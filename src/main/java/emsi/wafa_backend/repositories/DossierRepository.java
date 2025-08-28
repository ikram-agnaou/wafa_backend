package emsi.wafa_backend.repositories;

import emsi.wafa_backend.entities.Dossier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DossierRepository extends JpaRepository<Dossier, Long> {
    // Tous les dossiers d’un client
    List<Dossier> findByClientId(Long clientId);

    // Pagination si besoin directement par repo
    Page<Dossier> findAll(Pageable pageable);
}
