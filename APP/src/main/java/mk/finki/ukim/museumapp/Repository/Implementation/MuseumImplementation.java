package mk.finki.ukim.museumapp.Repository.Implementation;

import mk.finki.ukim.museumapp.PipeAndFilter.Service.MuseumService;
import mk.finki.ukim.museumapp.PipeAndFilter.model.Museum;
import mk.finki.ukim.museumapp.Repository.MuseumJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 */
@Service
public class MuseumImplementation implements MuseumService {
 private final MuseumJPA museumJPA;

    @Autowired
    public MuseumImplementation(MuseumJPA museumJPA) {
        this.museumJPA = museumJPA;
    }


    /**
     * @return A list of Museum objects representing museums.
     */
    @Override
    public List<Museum> getMuseums() {
        return museumJPA.findAllBy();
    }

    /**
     * @param search The search criteria to filter museums.
     * @return
     */
    @Override
    public List<Museum> searchmuseums(String search) {
        return museumJPA.findMuseumsByNameContainingIgnoreCase(search);
    }

    @Override
    public List<Museum> getOpenNow() {
        return museumJPA.findMuseumsByOpeningHoursIsNot("Unknown");
    }

    /**
     * @return A list of Museum objects representing museums with free entry.
     */
    @Override
    public List<Museum> getFreeEntry() {
        return museumJPA.findMuseumsByFeeNotContaining("Unknown");
    }

    /**
     * @return A list of Museum objects representing museums with internet access.
     */
    @Override
    public List<Museum> getInternetAccess() {
        return museumJPA.findMuseumsByInternetAccessContaining("yes");
    }

    /**
     * @return A list of Museum objects representing museums in Skopje.
     */
    @Override
    public List<Museum> getSkopje() {
        return museumJPA.findMuseumsByStreetContains("Skopje");
    }

    /**
     * @param name           The name of the museum. This is a required field.
     * @param latitude       The latitude of the museum's location.
     * @param longitude      The longitude of the museum's location.
     * @param street         The street address of the museum.
     * @param email          The email address of the museum.
     * @param internetAccess The type of internet access available at the museum.
     * @param wikidata       The Wikidata identifier for the museum.
     * @param openingHours   The opening hours of the museum.
     * @param phone          The phone number of the museum.
     * @param fee            The general fee information for the museum.
     * @param charge         The specific charge details for the museum.
     * @param website        The website URL of the museum.
     * @return
     */
    @Override
    public Museum createMuseum(String name, double latitude, double longitude, String street, String email, String internetAccess, String wikidata, String openingHours, String phone, String fee, String charge, String website) {
        return museumJPA.save(new Museum(name,latitude,longitude,street,email,internetAccess,wikidata,openingHours,phone,fee,charge,website));
    }

    /**
     * @param id The ID of the museum to be deleted. This is a required field.
     */
    @Override
    public void deleteMuseum(int id) {
        museumJPA.deleteById(id);
    }

    /**
     * @param id The ID of the museum to be retrieved.
     * @return The Museum object with the specified ID.
     * @apiNote This method returns a museum.
     */
    @Override
    public Museum getMuseum(int id) {
        return museumJPA.findMuseumById(id);
    }
}
