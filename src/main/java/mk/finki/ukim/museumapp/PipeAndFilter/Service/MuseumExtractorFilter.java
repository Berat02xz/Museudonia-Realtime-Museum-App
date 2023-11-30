package mk.finki.ukim.museumapp.PipeAndFilter.Service;

import com.fasterxml.jackson.databind.JsonNode;
import mk.finki.ukim.museumapp.PipeAndFilter.model.Museum;

import java.util.ArrayList;
import java.util.List;

//-----MUSEUM DATA EXTRACTOR FROM JSON FILE
public class MuseumExtractorFilter implements Filter {
    private Filter nextFilter;
    private static List<Museum> museums = new ArrayList<>();

    public MuseumExtractorFilter(Filter nextFilter) {
        this.nextFilter = nextFilter;
    }

    @Override
    public void process(Object data) {
        JsonNode jsonData = (JsonNode) data;
        JsonNode elements = jsonData.get("elements");


        for (JsonNode element : elements) {
            if (element.has("tags")) {
                JsonNode tags = element.get("tags");
                if (tags.has("tourism") && tags.get("tourism").asText().equals("museum")) {
                    museums.add(createMuseum(element));
                }
            }
        }

        if (nextFilter != null) {
            nextFilter.process(museums);
        }
    }

    public static List<Museum> getMuseums() {
        return museums;
    }

    private Museum createMuseum(JsonNode node) {
        JsonNode tags = node.get("tags");

        return new Museum(
                tags.has("name") ? tags.get("name").asText() : null,
                node.has("lat") ? node.get("lat").asDouble() : 0.0,
                node.has("lon") ? node.get("lon").asDouble() : 0.0,
                tags.has("addr:street") ? tags.get("addr:street").asText() : null,
                tags.has("email") ? tags.get("email").asText() : null,
                tags.has("internet_access") ? tags.get("internet_access").asText() : null,
                tags.has("wikidata") ? tags.get("wikidata").asText() : null,
                tags.has("opening_hours") ? tags.get("opening_hours").asText() : null,
                tags.has("contact:phone") ? tags.get("contact:phone").asText() : null,
                tags.has("fee") ? tags.get("fee").asText() : null,
                tags.has("charge") ? tags.get("charge").asText() : null,
                tags.has("website") ? tags.get("website").asText() : null
        );
    }
}
