package emsi.wafa_backend.repositories;

import emsi.wafa_backend.entities.HistoriqueStatutSAV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueStatutSAVRepository extends JpaRepository<HistoriqueStatutSAV, Long> {
}
