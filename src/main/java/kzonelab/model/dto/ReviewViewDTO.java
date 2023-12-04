package kzonelab.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReviewViewDTO {

    private Long id;
    private Long reviewerId;

    private Long reviewedUserId;
    private String text;
}
