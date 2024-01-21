package mk.finki.ukim.museumapp.Repository;

import mk.finki.ukim.museumapp.PipeAndFilter.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewJPA extends JpaRepository<Review, Long> {

    /**
     * @param MuseumId int
     * @return A list of Review objects representing reviews.
     */
    List<Review> findReviewsByMuseumId(int MuseumId);

    /**
     * @return A list of Review objects representing reviews.
     */
    List<Review> findAllBy();

    /**
     * @param id int
     * @return A Review object representing a review.
     */
    void deleteById(Long id);
}
