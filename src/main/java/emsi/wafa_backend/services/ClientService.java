package emsi.wafa_backend.services;

import emsi.wafa_backend.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClientService {
    Client create(Client c);
    Client update(Long id, Client c);
    void delete(Long id);
    Client get(Long id);
    List<Client> list();
    Page<Client> page(Pageable pageable);
}
