package emsi.wafa_backend.restcontrollers;


import emsi.wafa_backend.entities.OperationSAV;
import emsi.wafa_backend.entities.RAPOperation;
import emsi.wafa_backend.entities.RATOperation;
import emsi.wafa_backend.services.OperationSAVService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class OperationSAVRestController {

    private final OperationSAVService savService;

    // Créer une opération RAP pour un dossier
    @PostMapping("/dossiers/{dossierId}/sav/rap")
    public ResponseEntity<RAPOperation> createRAP(@PathVariable Long dossierId, @RequestBody @Valid RAPOperation rap){
        return ResponseEntity.status(HttpStatus.CREATED).body(savService.createRAP(dossierId, rap));
    }

    // Créer une opération RAT pour un dossier
    @PostMapping("/dossiers/{dossierId}/sav/rat")
    public ResponseEntity<RATOperation> createRAT(@PathVariable Long dossierId, @RequestBody @Valid RATOperation rat){
        return ResponseEntity.status(HttpStatus.CREATED).body(savService.createRAT(dossierId, rat));
    }

    // Détail d'une opération SAV (RAP ou RAT)
    @GetMapping("/sav/{id}")
    public ResponseEntity<OperationSAV> get(@PathVariable Long id){
        return ResponseEntity.ok(savService.get(id));
    }

    // Liste des opérations SAV d'un dossier
    @GetMapping("/dossiers/{dossierId}/sav")
    public ResponseEntity<List<OperationSAV>> listByDossier(@PathVariable Long dossierId){
        return ResponseEntity.ok(savService.listByDossier(dossierId));
    }

    @DeleteMapping("/sav/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        savService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

