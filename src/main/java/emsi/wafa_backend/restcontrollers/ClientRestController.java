package emsi.wafa_backend.restcontrollers;

import emsi.wafa_backend.entities.Client;
import emsi.wafa_backend.services.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientRestController {

    private final ClientService clientService;

    @PostMapping
    public ResponseEntity<Client> create(@RequestBody @Valid Client c){
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(c));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> get(@PathVariable Long id){
        return ResponseEntity.ok(clientService.get(id));
    }

    @GetMapping
    public ResponseEntity<List<Client>> list(){
        return ResponseEntity.ok(clientService.list());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> update(@PathVariable Long id, @RequestBody @Valid Client c){
        return ResponseEntity.ok(clientService.update(id, c));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
