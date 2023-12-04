package kzonelab.Service;

import kzonelab.Exception.UserNotFoundException;
import kzonelab.Exception.UserRatingNotFoundException;
import kzonelab.model.Entity.UserRating;
import kzonelab.model.dto.UserCreateDTO;
import kzonelab.model.dto.UserViewDTO;
import java.util.List;
import java.util.Optional;

public interface UserRatingService {

    List<UserRating> getAllUserRatings();

    Optional<UserRating> getUserRatingById(Long userRatingId);

    void createUserRating(UserCreateDTO userDTO);

    List<UserViewDTO> getAllUsers();

    Optional<UserViewDTO> getUserById(Long userId);

    void createUser(UserCreateDTO userDTO);

    default UserRating getUserRatingByIdOrThrow(Long userRatingId) {
        return getUserRatingById(userRatingId)
                .orElseThrow(() -> new UserRatingNotFoundException("User rating not found with ID: " + userRatingId));
    }

    default UserViewDTO getUserByIdOrThrow(Long userId) {
        return getUserById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with ID: " + userId));
    }
}
