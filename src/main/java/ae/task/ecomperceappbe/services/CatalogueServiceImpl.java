package ae.task.ecomperceappbe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ae.task.ecomperceappbe.daos.CatalogueRepository;
import ae.task.ecomperceappbe.models.CatalogueItem;
import ae.task.ecomperceappbe.models.User;
import ae.task.ecomperceappbe.rest.dtos.params;
@Service
public class CatalogueServiceImpl implements CatalogueService{

	@Autowired
	private CatalogueRepository catalogueRepository;
	
	public Optional<CatalogueItem> findById(Long id){
		return catalogueRepository.findById(id);
}
}
