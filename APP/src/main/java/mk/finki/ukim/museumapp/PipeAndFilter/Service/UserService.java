package mk.finki.ukim.museumapp.PipeAndFilter.Service;

import mk.finki.ukim.museumapp.PipeAndFilter.model.User;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 */
@Service
public interface UserService {
    /**
     * @param username String
     * @param password String
     * @return User
     * @apiNote This method returns a user.
     * @implNote This implementation consists of the username and password.
     * @since 1.0
     */
    User getUser(String username, String password);

    /**
     * @param username String
     * @return Boolean
     * @apiNote This method checks if the user exists.
     * @implNote This implementation consists of the username.
     * @since 1.0
     */
    Boolean userExist(String username);

    /**
     * @param username String
     * @param password String
     * @param email String
     * @return User
     * @apiNote This method creates a user.
     * @implNote This implementation consists of the username, password and email.
     * @since 1.0
     */
    User createUser(String username, String password, String email);
}
