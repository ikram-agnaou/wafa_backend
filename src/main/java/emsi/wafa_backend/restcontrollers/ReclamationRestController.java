package emsi.wafa_backend.restcontrollers;


import emsi.wafa_backend.entities.Reclamation;
import emsi.wafa_backend.services.ReclamationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ReclamationRestController {

    private final ReclamationService reclamationService;

    // Créer une réclamation pour un client
    @PostMapping("/clients/{clientId}/reclamations")
    public ResponseEntity<Reclamation> create(@PathVariable Long clientId, @RequestBody @Valid Reclamation r){
        return ResponseEntity.status(HttpStatus.CREATED).body(reclamationService.create(clientId, r));
    }

    @GetMapping("/reclamations/{id}")
    public ResponseEntity<Reclamation> get(@PathVariable Long id){
        return ResponseEntity.ok(reclamationService.get(id));
    }

    @GetMapping("/reclamations")
    public ResponseEntity<List<Reclamation>> list(){
        return ResponseEntity.ok(reclamationService.list());
    }

    // Toutes les réclamations d'un client
    @GetMapping("/clients/{clientId}/reclamations")
    public ResponseEntity<List<Reclamation>> listByClient(@PathVariable Long clientId){
        return ResponseEntity.ok(reclamationService.listByClient(clientId));
    }

    @PutMapping("/reclamations/{id}")
    public ResponseEntity<Reclamation> update(@PathVariable Long id, @RequestBody @Valid Reclamation r){
        return ResponseEntity.ok(reclamationService.update(id, r));
    }

    @DeleteMapping("/reclamations/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        reclamationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

