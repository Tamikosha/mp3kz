package kzonelab.Controller;

import kzonelab.model.dto.UserCreateDTO;
import kzonelab.model.dto.UserViewDTO;
import kzonelab.Service.UserRatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/user-ratings")
@Slf4j
public class UserController {

    private final UserRatingService userRatingService;

    @Autowired
    public UserController(UserRatingService userRatingService) {
        this.userRatingService = userRatingService;
    }

    @GetMapping("/ratings")
    public ResponseEntity<List<UserViewDTO>> getAllUsersWithRatings() {
        log.info("Received request to get all users with ratings");
        List<UserViewDTO> users = userRatingService.getAllUsers();
        log.debug("Users with ratings: {}, users");
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long userId) {
        log.info("Received request to get user by ID: {}", userId);
        Optional<UserViewDTO> user = userRatingService.getUserById(userId);
        if (user.isPresent()){
            log.debug("User found: {}", user.get());
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            log.warn("User not found with ID: {}", userId);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createUser(@RequestBody @Valid UserCreateDTO userDTO) {
        log.info("Received request to create a new user");
        userRatingService.createUser(userDTO);
        log.info("User created succesfully");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/createRating")
    public ResponseEntity<Void> createUserWithRating(@RequestBody @Valid UserCreateDTO userDTO) {
        log.info("Received reques to create a new user with rating");
        userRatingService.createUserRating(userDTO);
        log.info("User with rating created successfully");
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
