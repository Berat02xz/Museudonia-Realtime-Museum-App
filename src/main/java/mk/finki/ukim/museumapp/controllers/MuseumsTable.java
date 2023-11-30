package mk.finki.ukim.museumapp.controllers;


import mk.finki.ukim.museumapp.PipeAndFilter.Service.MuseumExtractorFilter;
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

        @GetMapping("/edit.html")
        public String getMuseums(Model model, @RequestParam(required = false) String error) {
            List<Museum> museums = MuseumExtractorFilter.getMuseums();
            model.addAttribute("museums", museums);
            model.addAttribute("bodyContent", "museums");
            model.addAttribute("error", error);
            return "edit";
        }


        @GetMapping
        public String getIndex(Model model) {
            List<Museum> museums = MuseumExtractorFilter.getMuseums();
            model.addAttribute("museums", museums);
            return "index";
        }
}
