package mk.finki.ukim.museumapp.Repository;

import mk.finki.ukim.museumapp.PipeAndFilter.model.Museum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MuseumJPA extends JpaRepository<Museum, Integer> {

    List<Museum> findAllBy();
}
