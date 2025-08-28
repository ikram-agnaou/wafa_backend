package emsi.wafa_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.*;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Dossier {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false)
    private Client client;
    private Double montant;
    private Integer dureeMois; private Double taux;
    private LocalDate dateDebut;
    @OneToMany(mappedBy="dossier", cascade=CascadeType.ALL)
    private List<Echeance> echeances=new ArrayList<>();
}
