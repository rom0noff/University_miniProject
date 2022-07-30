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
public class StudentDto {
    //
    private Long id;
    @JsonProperty("fullName")
    private String fullName;
    @JsonProperty("phone")
    private String phone;
}
