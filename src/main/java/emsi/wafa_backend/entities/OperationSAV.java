package emsi.wafa_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="sav_type")
public abstract class OperationSAV {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false)
    private Dossier dossier;
    private Double montantDemande;
    private LocalDateTime createdAt=LocalDateTime.now();
}
