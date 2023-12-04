package kzonelab.Service;

import kzonelab.Repository.UserRatingRepository;
import kzonelab.Repository.UserRepository;
import kzonelab.Service.UserRatingService;
import kzonelab.model.Entity.User;
import kzonelab.model.Entity.UserRating;
import kzonelab.model.dto.UserCreateDTO;
import kzonelab.model.dto.UserViewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserRatingServiceImpl implements UserRatingService {

    private final UserRepository userRepository;
    private final UserRatingRepository userRatingRepository;

    @Autowired
    public UserRatingServiceImpl(UserRepository userRepository, UserRatingRepository userRatingRepository) {
        this.userRepository = userRepository;
        this.userRatingRepository = userRatingRepository;
    }

    @Override
    public List<UserRating> getAllUserRatings() {
        return userRatingRepository.findAll();
    }

    @Override
    public Optional<UserRating> getUserRatingById(Long userRatingId) {
        return userRatingRepository.findById(userRatingId);
    }

    @Override
    public void createUserRating(UserCreateDTO userDTO) {
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(userDTO.getPassword());

        User savedUser = userRepository.save(newUser);

        // Создаем UserRating с начальными значениями
        UserRating newUserRating = UserRating.builder()
                .user(savedUser)
                .averageRating(0.0)
                .totalRatings(0)
                .positiveRatings(0)
                .negativeRatings(0)
                .build();

        userRatingRepository.save(newUserRating);
    }

    @Override
    public List<UserViewDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this::convertToUserViewDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<UserViewDTO> getUserById(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.map(this::convertToUserViewDTO);
    }

    @Override
    public void createUser(UserCreateDTO userDTO) {
        User newUser = new User();
        newUser.setUsername(userDTO.getUsername());
        newUser.setEmail(userDTO.getEmail());
        newUser.setPassword(userDTO.getPassword());

        userRepository.save(newUser);
    }

    // Другие методы, если необходимо

    private UserViewDTO convertToUserViewDTO(User user) {
        return UserViewDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }
}
