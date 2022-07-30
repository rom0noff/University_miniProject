package uz.university.miniproject.entity.model;
import javax.persistence.*;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "payment")
public class Payment implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sum")
    private String sum;
    @Column(name = "description")
    private String description;
}
