package mk.finki.ukim.museumapp.controllers;


import mk.finki.ukim.museumapp.PipeAndFilter.Service.MuseumService;
import mk.finki.ukim.museumapp.PipeAndFilter.model.Museum;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@Controller
@RequestMapping("/")
public class MuseumsTable {
    private final MuseumService museumService;

    public MuseumsTable(MuseumService museumService) {
        this.museumService = museumService;
    }

    @GetMapping("/edit.html")
        public String getMuseums(Model model, @RequestParam(required = false) String error) {
            List<Museum> museums = museumService.getMuseums();
            model.addAttribute("museums", museums);
            model.addAttribute("bodyContent", "museums");
            model.addAttribute("error", error);
            return "edit";
        }


        @GetMapping
        public String getIndex(Model model) {
            List<Museum> museums = museumService.getMuseums();
            model.addAttribute("museums", museums);
            return "index";
        }

        @GetMapping("/search")
        String getSearch(Model model, @RequestParam String search) {
            List<Museum> filteredMuseums = museumService.searchmuseums(search);
            model.addAttribute("museums", filteredMuseums);
            return "index";
        }

        @GetMapping("/OpenNow")
        String getOpenNow(Model model) {
               List<Museum> filteredMuseums = museumService.getOpenNow();
               model.addAttribute("museums", filteredMuseums);
               return "index";
        }

        @GetMapping("/freeentry")
        String getFreeEntry(Model model) {
               List<Museum> filteredMuseums = museumService.getFreeEntry();
               model.addAttribute("museums", filteredMuseums);
               return "index";
        }

        @GetMapping("/InternetAccess")
        String getInternetAccess(Model model) {
               List<Museum> filteredMuseums = museumService.getInternetAccess();
               model.addAttribute("museums", filteredMuseums);
               return "index";
        }

        @GetMapping("/All")
        String getAll(Model model) {
               List<Museum> museums = museumService.getMuseums();
               model.addAttribute("museums", museums);
               return "index";
        }

        @GetMapping("/Skopje")
        String getSkopje(Model model) {
               List<Museum> filteredMuseums = museumService.getSkopje();
               model.addAttribute("museums", filteredMuseums);
               return "index";
        }


}
