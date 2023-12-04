package kzonelab.model.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RatingCreateDTO {

    private Long userId;

    @Min(value = 1, message = "Stars must be at least 1")
    @Max(value = 5, message = "Stars cannot be more than 5")
    private int stars;

    @NotBlank(message = "Comment is required")
    private String comment;


}
