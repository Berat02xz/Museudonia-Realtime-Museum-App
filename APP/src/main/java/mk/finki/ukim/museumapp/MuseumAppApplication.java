package mk.finki.ukim.museumapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @version 1.0
 */
@SpringBootApplication
public class MuseumAppApplication {

    /**
     * @param args String[]
     * @apiNote This method runs the application.
     * @implNote This implementation consists of the args.
     * @since 1.0
     *
     *
     * @Note This method runs the application. Only uncomment if you want to add to the database.
     */
    public static void main(String[] args) {
        SpringApplication.run(MuseumAppApplication.class, args);

        //ONLY UNCCOMENT IF YOU WANNA ADD TO DB
        //PipeAndFilter.main(null);
    }
}
