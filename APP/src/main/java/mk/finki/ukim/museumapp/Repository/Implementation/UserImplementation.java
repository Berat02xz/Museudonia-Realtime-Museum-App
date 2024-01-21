package mk.finki.ukim.museumapp.Repository.Implementation;

import mk.finki.ukim.museumapp.PipeAndFilter.Service.UserService;
import mk.finki.ukim.museumapp.PipeAndFilter.model.User;
import mk.finki.ukim.museumapp.Repository.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 */
@Service
public class UserImplementation implements UserService {

    private final UserJPA userJPA;

    @Autowired
    public UserImplementation(UserJPA userJPA) {
        this.userJPA = userJPA;
    }

    /**
     * @param username String representing the username.
     * @param password String representing the password.
     * @return A User object representing a user.
     */
    @Override
    public User getUser(String username, String password) {
        return userJPA.findUserByUsernameAndPassword(username,password);
    }

    /**
     * @param username String representing the username.
     * @return A boolean value representing if the user exists.
     * @apiNote This method checks if the user exists. If the user exists, it returns true, otherwise it returns false.
     */
    @Override
    public Boolean userExist(String username) {
        User user = userJPA.findUserByUsername(username);
        if (user == null)
            return false;
        else {}
        return true;
    }

    /**
     * @param username String representing the username.
     * @param password String representing the password.
     * @param email    String representing the email.
     * @return A User object representing a user.
     * @apiNote This method creates a user.
     * @implNote This implementation consists of the username, password and email.
     */
    @Override
    public User createUser(String username, String password, String email) {
        return userJPA.save(new User(username,password,email));
    }
}
