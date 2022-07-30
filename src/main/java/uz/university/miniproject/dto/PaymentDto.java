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
public class PaymentDto {
    //
    private Long id;
    @JsonProperty("sum")
    private String sum;
    @JsonProperty("description")
    private String description;
}
