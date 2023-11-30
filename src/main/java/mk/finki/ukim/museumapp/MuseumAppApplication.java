package mk.finki.ukim.museumapp;

import mk.finki.ukim.museumapp.PipeAndFilter.PipeAndFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MuseumAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MuseumAppApplication.class, args);
        PipeAndFilter.main(null);
    }
}
