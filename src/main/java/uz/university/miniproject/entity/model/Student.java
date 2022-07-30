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
@Table(name = "student")
public class Student implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "fullName")
    private String fullName;
    @Column(name = "phone")
    private String phone;
}
