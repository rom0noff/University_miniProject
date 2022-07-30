package uz.university.miniproject.entity.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "course")
public class Course implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
    @Column(name = "duration")
    private String duration;
}
