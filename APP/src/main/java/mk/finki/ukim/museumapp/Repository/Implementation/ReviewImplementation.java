package mk.finki.ukim.museumapp.Repository.Implementation;

import mk.finki.ukim.museumapp.PipeAndFilter.Service.ReviewService;
import mk.finki.ukim.museumapp.PipeAndFilter.model.Review;
import mk.finki.ukim.museumapp.Repository.MuseumJPA;
import mk.finki.ukim.museumapp.Repository.ReviewJPA;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version 1.0
 */
@Repository
public class ReviewImplementation implements ReviewService {
    public final ReviewJPA reviewJPA;
    public final MuseumJPA museumJPA;

    public ReviewImplementation(ReviewJPA reviewJPA, MuseumJPA museumJPA) {
        this.reviewJPA = reviewJPA;
        this.museumJPA = museumJPA;
    }

    /**
     * @param MuseumId int representing the museum id.
     * @return A list of Review objects representing reviews.
     */
    @Override
    public List<Review> GetReviews(int MuseumId) {
        return reviewJPA.findReviewsByMuseumId(MuseumId);
    }

    /**
     * @return A list of Review objects representing reviews.
     * @apiNote This method returns a list of reviews.
     */
    @Override
    public List<Review> GetAllReviews() {
        return reviewJPA.findAllBy();
    }

    /**
     * @param id int representing the id.
     * @apiNote This method deletes a review.
     */
    @Override
    public void deleteReview(int id) {
        reviewJPA.deleteById((long) id);
    }

    /**
     * @param review    String
     * @param username  String
     * @param stars     int
     * @param museum_id int
     * @return A Review object representing a review.
     * @apiNote This method saves a review.
     * @implNote This implementation consists of the review, username, stars and museum id.
     * @since 1.0
     */
    @Override
    public Review saveReview(String review, String username, int stars, int museum_id) {
        return reviewJPA.save(new Review(review, username, stars, museumJPA.findById(museum_id).get()));
    }
}
