package Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import Model.User;


public interface IUserRepository extends JpaRepository<User, Long>{

	Optional<User> findByUsername(String username);
}
