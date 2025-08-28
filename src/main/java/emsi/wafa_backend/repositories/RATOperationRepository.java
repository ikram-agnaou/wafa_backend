package emsi.wafa_backend.repositories;

import emsi.wafa_backend.entities.RATOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RATOperationRepository extends JpaRepository<RATOperation, Long> {
}
