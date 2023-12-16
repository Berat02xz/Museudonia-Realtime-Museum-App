package mk.finki.ukim.museumapp.PipeAndFilter.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Data
@Entity
@Table(name = "Reviews")
public class Review {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int MuseumId;
    private String review;
    private String username;
    private int stars;

    public Review() {
    }

    public Review(int MuseumId, String review, String username, int stars) {
        this.MuseumId = MuseumId;
        this.review = review;
        this.username = username;
        this.stars = stars;
    }

}
