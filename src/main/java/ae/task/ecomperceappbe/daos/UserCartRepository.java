package ae.task.ecomperceappbe.daos;

import java.util.List;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ae.task.ecomperceappbe.models.CatalogueItem;
import ae.task.ecomperceappbe.models.User;
import ae.task.ecomperceappbe.models.UserCart;

@Repository
public interface UserCartRepository extends JpaRepository<UserCart, Long>{

	UserCart findByUser(User user);
	
	@Query("SELECT uc FROM UserCart uc WHERE uc.user.id =:userId")
    List<UserCart> findByUserId(@Param("userId") Long userId);
	

}
