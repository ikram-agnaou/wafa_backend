package emsi.wafa_backend.services;

import emsi.wafa_backend.entities.Echeance;

import java.util.List;

public interface EcheanceService {
    Echeance create(Long dossierId, Echeance e);
    Echeance update(Long id, Echeance e);
    void delete(Long id);
    Echeance get(Long id);
    List<Echeance> listByDossier(Long dossierId);
}
