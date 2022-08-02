package uz.university.miniproject.entity.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "time_table")
public class TimeTable implements Serializable {
    //
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "start_Time")
    private String start_time;
    @Column(name = "end_Time")
    private String end_time;

    @ManyToOne
    @JoinColumn(name = "day_id")
    private Day day;

    @ManyToMany
    @JoinTable(
            name = "group_time_table",
            joinColumns = {@JoinColumn(name = "time_table_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id", referencedColumnName = "id")}
    )
    List<TimeTable> tables = new LinkedList<>();

}
