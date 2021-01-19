package ae.task.ecomperceappbe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ae.task.ecomperceappbe.models.User;
import ae.task.ecomperceappbe.rest.dtos.Cart;
import ae.task.ecomperceappbe.rest.dtos.CheckoutItemsDto;
import ae.task.ecomperceappbe.rest.dtos.FinalBillDto;
import ae.task.ecomperceappbe.rest.dtos.params;
import ae.task.ecomperceappbe.services.UserCartService;

@RestController
public class eshopController {

	@Autowired
	private UserCartService userCartService;

	@RequestMapping(value = "/cart", method = RequestMethod.POST)
	public List<CheckoutItemsDto> addToCart(@RequestBody Cart cart)

	{
		return userCartService.addToCart(cart);
	}
	
	@RequestMapping(value = "/bill/{userId}", method = RequestMethod.GET)
	public FinalBillDto generateBill(@PathVariable String userId)

	{
		return userCartService.generateFinalBill(Long.valueOf(userId));
	}
}
