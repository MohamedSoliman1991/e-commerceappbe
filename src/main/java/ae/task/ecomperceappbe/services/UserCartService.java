package ae.task.ecomperceappbe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ae.task.ecomperceappbe.daos.UserRepository;
import ae.task.ecomperceappbe.models.User;
import ae.task.ecomperceappbe.rest.dtos.Cart;
import ae.task.ecomperceappbe.rest.dtos.CheckoutItemsDto;
import ae.task.ecomperceappbe.rest.dtos.FinalBillDto;


public interface UserCartService {
	
	List<CheckoutItemsDto> addToCart(Cart cart);
	FinalBillDto generateFinalBill(Long UserId);

	

}
