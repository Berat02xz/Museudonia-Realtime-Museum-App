package mk.finki.ukim.museumapp.PipeAndFilter.Service;

import mk.finki.ukim.museumapp.PipeAndFilter.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @apiNote This class represents a review service.
 * @implNote This implementation consists of the reviews.
 * @since 1.0
 */
@Service
public interface ReviewService {
    /**
     * @param MuseumId int
     * @return List<Review>
     * @apiNote This method returns a list of reviews.
     * @implNote This implementation consists of the museum id.
     * @since 1.0
     */
    List<Review> GetReviews(int MuseumId);


    /**
     * @return List<Review>
     * @apiNote This method returns a list of reviews.
     * @implNote This implementation consists of the reviews.
     * @since 1.0
     *
     */
    List<Review> GetAllReviews();

    /**
     * @param id int
     * @apiNote This method deletes a review.
     * @implNote This implementation consists of the id.
     * @since 1.0
     */
    void deleteReview(int id);

    /**
     * @param review String
     * @param username String
     * @param stars int
     * @param id int
     * @return Review
     * @apiNote This method saves a review.
     * @implNote This implementation consists of the review, username, stars and id.
     * @since 1.0
     */
    Review saveReview(String review, String username, int stars, int id);
}
