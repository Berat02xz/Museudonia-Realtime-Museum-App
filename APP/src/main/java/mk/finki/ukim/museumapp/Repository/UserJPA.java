package mk.finki.ukim.museumapp.Repository;

import mk.finki.ukim.museumapp.PipeAndFilter.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 */
@Repository
public interface UserJPA extends JpaRepository<User, Integer> {

        /**
         * @param username String
         * @param password
         * @return      A User object representing a user.
         * @apiNote     This method returns a user.
         */
        User findUserByUsernameAndPassword(String username, String password);

        /**
         * @param username String
         * @return     A User object representing a user.
         * @apiNote    This method returns a user.
         * @implNote   This implementation consists of the username.
         */
        User findUserByUsername(String username);
}
