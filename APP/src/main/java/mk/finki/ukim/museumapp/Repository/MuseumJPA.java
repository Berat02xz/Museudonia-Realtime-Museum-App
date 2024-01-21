package mk.finki.ukim.museumapp.Repository;

import mk.finki.ukim.museumapp.PipeAndFilter.model.Museum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @version 1.0
 */
@Repository
public interface MuseumJPA extends JpaRepository<Museum, Integer> {

    /**
     * @return A list of Museum objects representing museums.
     */
    List<Museum> findAllBy();

    /**
     * @param search The search criteria to filter museums.
     * @return A list of Museum objects that match the search criteria.
     */
    List<Museum> findMuseumsByNameContainingIgnoreCase(String search);

    /**
     * @param Unknown String
     * @return A list of Museum objects representing museums that are open now.
     */
    List<Museum> findMuseumsByOpeningHoursIsNot(String Unknown);

    /**
     * @param No String
     * @return A list of Museum objects representing museums with free entry.
     */
    List<Museum> findMuseumsByFeeNotContaining(String No);

    /**
     * @param Yes String
     * @return A list of Museum objects representing museums with internet access.
     */
    List<Museum> findMuseumsByInternetAccessContaining(String Yes);

    /**
     * @param Street String
     * @return A list of Museum objects representing museums with street.
     */
    List<Museum> findMuseumsByStreetContains(String Street);

    /**
     * @param id int
     * @return A Museum object representing a museum.
     * @apiNote This method returns a museum.
     */
    void deleteById(int id);

    /**
     * @param id int
     * @return A Museum object representing a museum.
     * @apiNote This method returns a museum.
     */
    Museum findMuseumById(int id);
}
