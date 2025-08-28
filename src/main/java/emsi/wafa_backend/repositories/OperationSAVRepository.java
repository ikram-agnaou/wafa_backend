package emsi.wafa_backend.repositories;

import emsi.wafa_backend.entities.OperationSAV;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OperationSAVRepository extends JpaRepository<OperationSAV, Long> {
    List<OperationSAV> findByDossierId(Long dossierId);

}
