package ae.task.ecomperceappbe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ae.task.ecomperceappbe.models.CatalogueItem;
import ae.task.ecomperceappbe.models.User;
import ae.task.ecomperceappbe.rest.dtos.params;

public interface CatalogueService{

	Optional<CatalogueItem> findById(Long id);
}
