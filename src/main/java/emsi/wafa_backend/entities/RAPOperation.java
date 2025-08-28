package emsi.wafa_backend.entities;

import jakarta.persistence.*;
import lombok.*;
@Data @EqualsAndHashCode(callSuper=true)
@Entity
@DiscriminatorValue("RAP")
public class RAPOperation extends OperationSAV { }

