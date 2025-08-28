package emsi.wafa_backend.restcontrollers;


import emsi.wafa_backend.entities.Echeance;
import emsi.wafa_backend.services.EcheanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EcheanceRestController {

    private final EcheanceService echeanceService;

    // Créer une échéance pour un dossier
    @PostMapping("/dossiers/{dossierId}/echeances")
    public ResponseEntity<Echeance> create(@PathVariable Long dossierId, @RequestBody @Valid Echeance e){
        return ResponseEntity.status(HttpStatus.CREATED).body(echeanceService.create(dossierId, e));
    }

    @GetMapping("/echeances/{id}")
    public ResponseEntity<Echeance> get(@PathVariable Long id){
        return ResponseEntity.ok(echeanceService.get(id));
    }

    // Toutes les échéances d'un dossier
    @GetMapping("/dossiers/{dossierId}/echeances")
    public ResponseEntity<List<Echeance>> listByDossier(@PathVariable Long dossierId){
        return ResponseEntity.ok(echeanceService.listByDossier(dossierId));
    }

    @PutMapping("/echeances/{id}")
    public ResponseEntity<Echeance> update(@PathVariable Long id, @RequestBody @Valid Echeance e){
        return ResponseEntity.ok(echeanceService.update(id, e));
    }

    @DeleteMapping("/echeances/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        echeanceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

