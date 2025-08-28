package emsi.wafa_backend.services;

import emsi.wafa_backend.entities.Client;
import emsi.wafa_backend.exceptions.NotFoundException;
import emsi.wafa_backend.repositories.ClientRepository;
import emsi.wafa_backend.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service @RequiredArgsConstructor @Transactional
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepo;

    @Override public Client create(Client c){ return clientRepo.save(c); }

    @Override public Client update(Long id, Client c){
        Client db = clientRepo.findById(id).orElseThrow(() -> new NotFoundException("Client "+id+" introuvable"));
        db.setNom(c.getNom());
        db.setPrenom(c.getPrenom());
        db.setEmail(c.getEmail());
        db.setPhone(c.getPhone());
        db.setCin(c.getCin());
        return db;
    }

    @Override public void delete(Long id){ clientRepo.deleteById(id); }

    @Override @Transactional(readOnly = true)
    public Client get(Long id){ return clientRepo.findById(id).orElseThrow(() -> new NotFoundException("Client "+id+" introuvable")); }

    @Override @Transactional(readOnly = true)
    public List<Client> list(){ return clientRepo.findAll(); }

    @Override @Transactional(readOnly = true)
    public Page<Client> page(Pageable pageable){ return clientRepo.findAll(pageable); }
}
