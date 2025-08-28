package emsi.wafa_backend.services;

import emsi.wafa_backend.entities.OperationSAV;
import emsi.wafa_backend.entities.RAPOperation;
import emsi.wafa_backend.entities.RATOperation;

import java.util.List;

public interface OperationSAVService {
    RAPOperation createRAP(Long dossierId, RAPOperation rap);
    RATOperation createRAT(Long dossierId, RATOperation rat);
    OperationSAV get(Long id);
    void delete(Long id);
    List<OperationSAV> listByDossier(Long dossierId);
}
