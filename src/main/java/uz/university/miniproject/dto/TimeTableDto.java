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
public class TimeTableDto {
    //
    private Long id;
    @JsonProperty("start_time")
    private String start_time;
    @JsonProperty("end_time")
    private String end_time;
}
