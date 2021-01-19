package ae.task.ecomperceappbe.daos;

import java.util.Optional;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ae.task.ecomperceappbe.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	void save(Optional<User> user);

}
