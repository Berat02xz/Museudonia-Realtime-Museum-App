package mk.finki.ukim.museumapp.controllers;


import mk.finki.ukim.museumapp.PipeAndFilter.Service.MuseumService;
import mk.finki.ukim.museumapp.PipeAndFilter.Service.UserService;
import mk.finki.ukim.museumapp.PipeAndFilter.model.Museum;
import mk.finki.ukim.museumapp.PipeAndFilter.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;



@Controller
@RequestMapping("/")
public class MuseumsTable {
    private final MuseumService museumService;
    private final UserService userService;

    public MuseumsTable(MuseumService museumService, UserService userService) {
        this.museumService = museumService;
        this.userService = userService;
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

        @PostMapping("/LoginMethod")
        String getLoginMethod(Model model, @RequestParam String username, @RequestParam String password){

        User user = userService.getUser(username, password);


        //check if role admin else return index
        if (user != null && user.getRole().equals("Admin")) {
                model.addAttribute("user", user);
                return "redirect:/edit.html";
            }
        if(user != null && user.getRole().equals("User")) {
            model.addAttribute("user", user);
            return "redirect:/";
        }

        if(user == null ) {
            return "redirect:/Login.html?error=Invalid username or password";
        }
            return "redirect:/Login.html?error=Error, Try again";
        }

        @GetMapping("/Login.html")
        String getLogin(Model model) {
        System.out.println("Login");
            return "Login";
        }

        @GetMapping("/Register.html")
        String getRegister(Model model) {
        System.out.println("Register");
            return "Register";
        }

        @PostMapping("/RegisterMethod")
        String getRegisterMethod(Model model, @RequestParam String username, @RequestParam String password, @RequestParam String email){

            Boolean userExists = userService.userExist(username);
            if(userExists) {
                return "redirect:/Register.html?error=Username already exists";
            }

            User user = userService.createUser(username, password, email);
            model.addAttribute("user", user);
            return "redirect:/";

        }

}
