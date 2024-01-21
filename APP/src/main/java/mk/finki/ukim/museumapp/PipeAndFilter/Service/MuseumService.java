package mk.finki.ukim.museumapp.PipeAndFilter.Service;

import mk.finki.ukim.museumapp.PipeAndFilter.model.Museum;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @apiNote This class represents a museum service.
 * @implNote This implementation consists of the museums.
 * @since 1.0
 * @see Museum
 * @see Service
 * @see List
 */
@Service
public interface MuseumService {
    /**
     * @return List<Museum>
     * @apiNote This method returns a list of museums.
     * @implNote This implementation consists of the museums.
     * @since 1.0
     */
    List<Museum> getMuseums();

    /**
     * @param search String
     * @return List<Museum>
     * @apiNote This method searches the museums in the list of museums. Filters them by name. Returns a list of museums.
     * @implNote This implementation consists of the search.
     * @since 1.0
     */
    /**
     * Searches for museums based on the specified search criteria.
     *
     * @param search The search criteria to filter museums.
     * @return A list of Museum objects that match the search criteria.
     */
    List<Museum> searchmuseums(String search);

    /**
     * Retrieves a list of museums that are currently open.
     *
     * @return A list of Museum objects representing museums that are open now.
     */
    List<Museum> getOpenNow();

    /**
     * Retrieves a list of museums that offer free entry.
     *
     * @return A list of Museum objects representing museums with free entry.
     */
    List<Museum> getFreeEntry();

    /**
     * Retrieves a list of museums that provide internet access.
     *
     * @return A list of Museum objects representing museums with internet access.
     */
    List<Museum> getInternetAccess();

    /**
     * Retrieves a list of museums located in Skopje.
     *
     * @return A list of Museum objects located in Skopje.
     */
    List<Museum> getSkopje();

    /**
     * Creates a new museum with the specified details.
     *
     * @param name          The name of the museum.
     * @param latitude      The latitude of the museum's location.
     * @param longitude     The longitude of the museum's location.
     * @param street        The street address of the museum.
     * @param email         The email address of the museum.
     * @param internetAccess The type of internet access available at the museum.
     * @param wikidata      The Wikidata identifier for the museum.
     * @param openingHours  The opening hours of the museum.
     * @param phone         The phone number of the museum.
     * @param fee           The general fee information for the museum.
     * @param charge        The specific charge details for the museum.
     * @param website       The website URL of the museum.
     * @return The newly created Museum object.
     */
    Museum createMuseum(String name, double latitude, double longitude, String street, String email,
                        String internetAccess, String wikidata, String openingHours, String phone,
                        String fee, String charge, String website);

    /**
     * Deletes the museum with the specified ID.
     *
     * @param id The ID of the museum to be deleted.
     */
    void deleteMuseum(int id);

    /**
     * Retrieves the museum with the specified ID.
     *
     * @param id The ID of the museum to be retrieved.
     * @return The Museum object with the specified ID.
     */
    Museum getMuseum(int id);

}
