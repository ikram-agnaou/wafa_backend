package emsi.wafa_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class HistoriqueStatutReclamation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false)
    private Reclamation reclamation;
    private String statut;
    private String comment;
    private LocalDateTime changedAt=LocalDateTime.now();
}
