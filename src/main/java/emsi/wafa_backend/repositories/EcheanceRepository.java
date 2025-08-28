package emsi.wafa_backend.repositories;

import emsi.wafa_backend.entities.Echeance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EcheanceRepository extends JpaRepository<Echeance, Long> {
}
