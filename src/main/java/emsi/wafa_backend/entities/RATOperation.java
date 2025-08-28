package emsi.wafa_backend.entities;

import jakarta.persistence.*;
import lombok.*;
@Data @EqualsAndHashCode(callSuper=true)
@Entity
@DiscriminatorValue("RAT")
public class RATOperation extends OperationSAV { }
