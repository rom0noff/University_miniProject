package uz.university.miniproject.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupDto {
    //
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("courseId")
    private Long courseId;
    @JsonProperty("teacherId")
    private Long teacherId;
    @JsonProperty("roomId")
    private Long roomId;
    @JsonProperty("start_date")
    private String start_date;
    @JsonProperty("end_date")
    private String end_date;
    @JsonProperty("status_id")
    private Long status_id;
}
