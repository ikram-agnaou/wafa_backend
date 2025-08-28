package emsi.wafa_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Echeance {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false)
    private Dossier dossier;
    private Integer numero;
    private LocalDate date;
    private Double montant;
    private Double reste;
}

