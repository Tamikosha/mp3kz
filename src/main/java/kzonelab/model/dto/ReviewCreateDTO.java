package kzonelab.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
public class ReviewCreateDTO {

    @NotNull(message = "Reviewer ID is required")
    private Long reviewerId;

    @NotNull(message = "Reviewed User ID is required")
    private Long reviewedUserId;

    @NotBlank(message = "Text is required")
    private String text;
}
