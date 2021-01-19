package ae.task.ecomperceappbe.daos;

import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ae.task.ecomperceappbe.models.CatalogueItem;
import ae.task.ecomperceappbe.models.User;

@Repository
public interface CatalogueRepository extends JpaRepository<CatalogueItem, Long>{

}
