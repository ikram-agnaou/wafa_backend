package emsi.wafa_backend.repositories;

import emsi.wafa_backend.entities.HistoriqueStatutReclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueStatutReclamationRepository extends JpaRepository<HistoriqueStatutReclamation, Long> {
}
