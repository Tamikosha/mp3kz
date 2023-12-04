package kzonelab.model.Entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column (name = "stars")
    private int stars;

    @Column (name = "comment")
    private String comment;

}

