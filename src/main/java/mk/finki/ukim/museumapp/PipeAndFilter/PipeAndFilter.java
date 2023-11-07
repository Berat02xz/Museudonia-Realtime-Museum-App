package mk.finki.ukim.museumapp.PipeAndFilter;

import mk.finki.ukim.museumapp.PipeAndFilter.Service.Filter;
import mk.finki.ukim.museumapp.PipeAndFilter.Service.JsonFileReaderFilter;
import mk.finki.ukim.museumapp.PipeAndFilter.Service.MuseumExtractorFilter;
import mk.finki.ukim.museumapp.PipeAndFilter.model.Museum;
import org.springframework.stereotype.Component;

import java.util.List;


//GLAVNA FUNKCIJA
@Component
public class PipeAndFilter {
    public static void main(String[] args) {
        Filter museumExtractorFilter = new MuseumExtractorFilter(null);
        Filter jsonFileReaderFilter = new JsonFileReaderFilter(museumExtractorFilter);

        jsonFileReaderFilter.process(null);

        List<Museum> museums = ((MuseumExtractorFilter) museumExtractorFilter).getMuseums();

        System.out.println("-------------------Museum Data extracted from the JSON document:");
        for (Museum museum : museums) {

            System.out.println(museum);
        }
    }
}