package emsi.wafa_backend.entities;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.*;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Reclamation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(optional=false)
    private Client client;
    private String sujet;
    @Column(length=2000)
    private String description;
    private LocalDateTime createdAt=LocalDateTime.now();
    @OneToMany(mappedBy="reclamation", cascade=CascadeType.ALL)
    private List<HistoriqueStatutReclamation> historiques=new ArrayList<>();
}

