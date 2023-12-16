package mk.finki.ukim.museumapp.Repository.Implementation;

import mk.finki.ukim.museumapp.PipeAndFilter.Service.MuseumService;
import mk.finki.ukim.museumapp.PipeAndFilter.model.Museum;
import mk.finki.ukim.museumapp.Repository.MuseumJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MuseumImplementation implements MuseumService {
 private final MuseumJPA museumJPA;

    @Autowired
    public MuseumImplementation(MuseumJPA museumJPA) {
        this.museumJPA = museumJPA;
    }


    @Override
    public List<Museum> getMuseums() {
        return museumJPA.findAllBy();
    }
}
