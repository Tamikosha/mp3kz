package kzonelab.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_ratings")
public class UserRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column (name = "averageRating")
    private double averageRating;

    @Column (name = "totalRatings")
    private int totalRatings;

    @Column (name = "positiveRatings")
    private int positiveRatings;

    @Column (name = "negativeRatings")
    private int negativeRatings;

}

