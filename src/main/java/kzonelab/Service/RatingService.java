package kzonelab.Service;

import kzonelab.model.Entity.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> getAllRatings();
    Rating getRatingById(Long ratingId);
    void saveRating(Rating rating);
}
