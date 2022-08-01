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
    @Column(name = "start_time")
    private String start_time;
    @Column(name = "end_time")
    private String end_time;

    @OneToMany(mappedBy = "timeTable", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<GroupTimeTable> groupTimeTables = new LinkedList<>();

    @ManyToOne
    @JoinColumn(name = "day_id")
    private Day day;

}
