package mk.finki.ukim.museumapp.PipeAndFilter.Service;

import mk.finki.ukim.museumapp.PipeAndFilter.model.Museum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MuseumService {
    List<Museum> getMuseums();

    List<Museum> searchmuseums(String search);

    List<Museum> getOpenNow();

    List<Museum> getFreeEntry();

    List<Museum> getInternetAccess();

    List<Museum> getSkopje();
}
