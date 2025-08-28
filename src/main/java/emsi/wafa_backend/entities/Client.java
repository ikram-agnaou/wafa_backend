package emsi.wafa_backend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*; import lombok.*;
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false, unique=true)
    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private String phone;
}
