package kzonelab.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RatingViewDTO {

    private Long id;
    private Long userId;
    private int stars;
    private String comment;

}