package emsi.wafa_backend.restcontrollers;

import emsi.wafa_backend.entities.Dossier;
import emsi.wafa_backend.services.DossierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/dossiers")
@RequiredArgsConstructor
public class DossierRestController {

    private final DossierService dossierService;

    // Création d'un dossier pour un client
    @PostMapping
    public ResponseEntity<Dossier> create(@RequestParam Long clientId, @RequestBody @Valid Dossier d){
        return ResponseEntity.status(HttpStatus.CREATED).body(dossierService.create(d, clientId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dossier> get(@PathVariable Long id){
        return ResponseEntity.ok(dossierService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Dossier>> list(){
        return ResponseEntity.ok(dossierService.list());
    }

    // Tous les dossiers d'un client
    @GetMapping("/by-client/{clientId}")
    public ResponseEntity<List<Dossier>> listByClient(@PathVariable Long clientId){
        return ResponseEntity.ok(dossierService.listByClient(clientId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Dossier> update(@PathVariable Long id, @RequestBody @Valid Dossier d){
        return ResponseEntity.ok(dossierService.update(id, d));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        dossierService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

