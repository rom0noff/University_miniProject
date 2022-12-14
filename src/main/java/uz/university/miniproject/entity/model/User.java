package uz.university.miniproject.entity.model;

import lombok.*;
import uz.university.miniproject.entity.enums.StatusEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "university_user")
public class User implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    private StatusEnum statusEnum;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "name")}

    )
    private Set<Role> roles = new HashSet<>();
}
