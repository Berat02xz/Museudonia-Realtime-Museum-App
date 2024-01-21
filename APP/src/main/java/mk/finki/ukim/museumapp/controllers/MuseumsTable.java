package mk.finki.ukim.museumapp.controllers;


import mk.finki.ukim.museumapp.PipeAndFilter.Service.MuseumService;
import mk.finki.ukim.museumapp.PipeAndFilter.Service.ReviewService;
import mk.finki.ukim.museumapp.PipeAndFilter.Service.UserService;
import mk.finki.ukim.museumapp.PipeAndFilter.model.Museum;
import mk.finki.ukim.museumapp.PipeAndFilter.model.Review;
import mk.finki.ukim.museumapp.PipeAndFilter.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @version 1.0
 * @apiNote This class represents a museum.
 * @implNote This implementation consists of the name, latitude, longitude, street, email, internetAccess, wikidata, openingHours, phone, fee, charge and website.
 * @since 1.0
 */
@Controller
@RequestMapping("/")
public class MuseumsTable {
    private final MuseumService museumService;
    private final UserService userService;
    public final ReviewService reviewService;

    public MuseumsTable(MuseumService museumService, UserService userService, ReviewService reviewService) {
        this.museumService = museumService;
        this.userService = userService;
        this.reviewService = reviewService;
    }

    /**
     * @param model model
     * @param error error
     * @return String
     * @apiNote Returns museums view with model attribute museums, bodyContent and error.
     * @implNote This implementation returns a string representation consisting of the museums, bodyContent and error.
     * @since 1.0
     */
    @GetMapping("/edit.html")
        public String getMuseums(Model model, @RequestParam(required = false) String error) {
            List<Museum> museums = museumService.getMuseums();
            model.addAttribute("museums", museums);
            model.addAttribute("bodyContent", "museums");
            model.addAttribute("error", error);
            return "edit";
        }


    /**
     * @param model model
     * @return String
     * @apiNote Returns main page with all museums.
     * @implNote This implementation returns a string representation consisting of the museums.
     * @since 1.0
     */
        @GetMapping
        public String getIndex(Model model) {
            List<Museum> museums = museumService.getMuseums();
            model.addAttribute("museums", museums);

            return "index";
        }

    /**
     * @param model model
     * @param search search
     * @return String
     * @apiNote Returns search results.
     * @implNote This implementation returns a string representation consisting of the museums.
     * @since 1.0
     */
        @GetMapping("/search")
        String getSearch(Model model, @RequestParam String search) {
            //if search is empty return all museums
            if(search.isEmpty()) {
                List<Museum> museums = museumService.getMuseums();
                model.addAttribute("museums", museums);
                return "index";
            }
            List<Museum> filteredMuseums = museumService.searchmuseums(search);
            model.addAttribute("museums", filteredMuseums);
            return "index";
        }

    /**
     * @param model model
     * @return String
     * @apiNote Filters the museums that are open now.
     * @implNote This implementation returns a string representation consisting of the museums.
     * @since 1.0
     */
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

    /**
     * @param model
     * @param username
     * @param password
     * @return String
     * @apiNote It is used to login the user, if user is admin it redirects to edit.html else it redirects to index.html.
     *
     * @implNote This implementation returns a string representation consisting of the user.
     * @since 1.0
     */
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

    /**
     * @param model model
     * @return String
     * @apiNote Returns to the Login view with model attribute user.
     * @implNote This implementation returns a string representation consisting of the user.
     * @since 1.0
     */
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

    /**
     * @param model
     * @param username
     * @param password
     * @param email
     * @return String
     * @apiNote It is used to register the user, if user exists it redirects to Register.html else it redirects to index.html.
     * @implNote This implementation returns a string representation consisting of the user.
     * @since 1.0
     */
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

    /**
     * @param model
     * @return String
     * @apiNote Returns to the MuseumEdit view with model attribute museum. Used to create a new museum.
     * @implNote This implementation returns a string representation consisting of the museum.
     * @since 1.0
     */
        @GetMapping("/museums/create")
        public String createMuseum(Model model) {
        System.out.println("EDIT MUSEUM");
            return "MuseumEdit";
        }

    /**
     * @param model
     * @return String
     * @apiNote Returns to the EditReviews view with model attribute reviews. Used to edit reviews.
     * @implNote This implementation returns a string representation consisting of the reviews.
     * @since 1.0
     */
        @GetMapping("/museums/editreviews")
        public String editReviews(Model model) {
            List<Review> reviews = reviewService.GetAllReviews();
            model.addAttribute("reviews", reviews);
            return "EditReviews";
        }

    /**
     * @param model
     * @param id
     * @param name
     * @param latitude
     * @param longitude
     * @param street
     * @param email
     * @param internetAccess
     * @param wikidata
     * @param openingHours
     * @param phone
     * @param fee
     * @param charge
     * @param website
     * @return String
     * @apiNote It is used to create a new museum, if museum exists it deletes the museum and creates a new one.
     * @implNote This implementation returns a string representation consisting of the museum.
     * @since 1.0
     * @see Museum
     */
        @PostMapping("/museum/add")
        public String createMuseum(Model model, @RequestParam int id, @RequestParam String name, @RequestParam String latitude, @RequestParam String longitude, @RequestParam String street, @RequestParam String email, @RequestParam String internetAccess, @RequestParam String wikidata, @RequestParam String openingHours, @RequestParam String phone, @RequestParam String fee, @RequestParam String charge, @RequestParam String website) {

            if(id != 0) {
                museumService.deleteMuseum(id);
                System.out.println("MUSEUM DELETED BEFORE ADDING NEW");
            }

            //cast string latitude to double
            double lat = Double.parseDouble(latitude);
            //cast string longitude to double
            double lon = Double.parseDouble(longitude);

            Museum museum = museumService.createMuseum(name, lat, lon, street, email, internetAccess, wikidata, openingHours, phone, fee, charge, website);
            System.out.println("MUSEUM CREATED");
            return "redirect:/edit.html";
        }

    /**
     * @param model
     * @param id
     * @return String
     * @apiNote It is used to delete a museum.
     * @implNote This implementation returns a string representation consisting of the museum.
     * @since 1.0
     */
        @GetMapping("/museums/delete/{id}")
        public String deleteMuseum(Model model, @PathVariable int id) {
            museumService.deleteMuseum(id);
            System.out.println("MUSEUM DELETED");
            return "redirect:/edit.html";
        }

    /**
     * @param model
     * @param id
     * @return String
     * @apiNote It is used to delete a review.
     * @implNote This implementation returns a string representation consisting of the review.
     * @since 1.0
     */
        @GetMapping("/reviews/delete/{id}")
        public String deleteReview(Model model, @PathVariable int id) {
            reviewService.deleteReview(id);
            System.out.println("REVIEW DELETED");
            return "redirect:/museums/editreviews";
        }

    /**
     * @param model
     * @param id
     * @return String
     * @apiNote It is used to edit a museum.
     * @implNote This implementation returns a string representation consisting of the museum.
     * @since 1.0
     */
        @GetMapping("/museums/edit/{id}")
        public String editMuseum(Model model, @PathVariable int id) {
            Museum museum = museumService.getMuseum(id);
            model.addAttribute("museum", museum);
            return "MuseumEdit";
        }

    /**
     * @param model
     * @param id
     * @return String
     * @apiNote It is used to add a review.
     * @implNote This implementation returns a string representation consisting of the museum.
     * @since 1.0
     */
        @GetMapping("/addreview/{id}")
        public String addReview(Model model, @PathVariable int id) {
            Museum museum = museumService.getMuseum(id);
            model.addAttribute("museum", museum);
            return "AddReview";
        }

    /**
     * @param model
     * @param museum_id
     * @param review
     * @param username
     * @param stars
     * @return String
     * @apiNote It is used to create a new review. Adds
     * @implNote This implementation returns a string representation consisting of the review.
     * @since 1.0
     */
        @PostMapping("/museum/createReview")
        public String addReview(Model model, @RequestParam int museum_id, @RequestParam String review, @RequestParam String username, @RequestParam int stars) {
            Review review1 = reviewService.saveReview(review, username, stars, museum_id);

            System.out.println("REVIEW CREATED");
            return "redirect:/";
        }

}
