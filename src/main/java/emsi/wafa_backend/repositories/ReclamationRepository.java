package emsi.wafa_backend.repositories;

import emsi.wafa_backend.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

    // permet de récupérer toutes les réclamations d’un client
    List<Reclamation> findByClientId(Long clientId);
}
