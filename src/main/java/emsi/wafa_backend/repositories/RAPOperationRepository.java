package emsi.wafa_backend.repositories;

import emsi.wafa_backend.entities.RAPOperation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RAPOperationRepository extends JpaRepository<RAPOperation, Long> {
}
