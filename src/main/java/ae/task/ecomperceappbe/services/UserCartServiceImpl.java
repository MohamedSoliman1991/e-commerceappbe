package ae.task.ecomperceappbe.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import ae.task.ecomperceappbe.common.UsersType;
import ae.task.ecomperceappbe.common.Utilities;
import ae.task.ecomperceappbe.daos.CatalogueRepository;
import ae.task.ecomperceappbe.daos.UserCartRepository;
import ae.task.ecomperceappbe.daos.UserRepository;
import ae.task.ecomperceappbe.models.CatalogueItem;
import ae.task.ecomperceappbe.models.User;
import ae.task.ecomperceappbe.models.UserCart;
import ae.task.ecomperceappbe.rest.dtos.Cart;
import ae.task.ecomperceappbe.rest.dtos.CheckoutItemsDto;
import ae.task.ecomperceappbe.rest.dtos.FinalBillDto;
import ae.task.ecomperceappbe.rest.dtos.OriginalBillDto;

@Service
public class UserCartServiceImpl implements UserCartService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	CatalogueRepository catalogueRepository;
	@Autowired
	UserCartRepository userCartRepository;

	@Override
	public List<CheckoutItemsDto> addToCart(Cart cart) {
		// Adding all items to userCart 
		Optional<User> user = userRepository.findById(cart.getUserId());
		List<Long> itemIds = new ArrayList<Long>();
		List<CheckoutItemsDto> CheckoutItemsDtoList =  new ArrayList<>();
		CheckoutItemsDto CheckoutItemsDto = null;
		CatalogueItem itemToCart = new CatalogueItem();
		UserCart userCart = new UserCart();
		for (int index = 0; index < cart.getSeletedProducts().size(); index++) {
			Optional<CatalogueItem> item = catalogueRepository.findById(cart.getSeletedProducts().get(index).getItemId());
			userCart.setUser(user.get());
			userCart.setCatalogueItem(item.get());
			userCart.setQuantity(cart.getSeletedProducts().get(index).getQuantity());
			CheckoutItemsDto = new CheckoutItemsDto();
			CheckoutItemsDto.setItemName(item.get().getItemName());
			CheckoutItemsDto.setQuantity(userCart.getQuantity());
			CheckoutItemsDto.setPrice(item.get().getItemPrice());
			userCartRepository.save(userCart);
		
			CheckoutItemsDtoList.add(CheckoutItemsDto);
			
		}
		return CheckoutItemsDtoList;
	}
	
	@Override
	public FinalBillDto generateFinalBill(Long userId)
	{
		// get total bill with all discounts if any
		Optional<User> user = userRepository.findById(userId);
		List<UserCart> userItemsList=  userCartRepository.findByUserId(userId);
		
		OriginalBillDto billDto = CalculateOriginalBill(userItemsList);
		Double finalBill = (billDto.getOrignalBill() * getUserDiscount(billDto.getUserType(), billDto.getCreatedDate()));
		finalBill = finalBill - getBillDiscount(finalBill);
		FinalBillDto finalBillDto = new FinalBillDto();
		finalBillDto.setOriginalAmount(billDto.getOrignalBill());
		finalBillDto.setTotalBillAmount(finalBill);
		return finalBillDto;
	}
	private double getBillDiscount (Double totalBillAmount)
	{
		// calculate the discount amount on total bill
	int hundredValues = totalBillAmount.intValue()/100;
	int finalBilldiscount = hundredValues*5;
		return finalBilldiscount ;	
	}

	private double getUserDiscount(String userType,String regisiteredDate)
	{
		// get discount based on userType
		if(userType.equalsIgnoreCase(UsersType.TypesEnum.EMPLOYEE.toString()))
		{
			return 0.30;
		}
		else
			if((userType.equalsIgnoreCase(UsersType.TypesEnum.affiliate.toString()))){
				return 0.1;
			}
			else
				if((userType.equalsIgnoreCase(UsersType.TypesEnum.CUSTOMER.toString())) && Utilities.compareWithRegisieredDate(regisiteredDate))
			return 0.5;
		return 1.0;
	}
	
	public OriginalBillDto CalculateOriginalBill(List<UserCart> CartItemsList)
	{
		// calculate bill before discount
		double originalBill = 0.0;
		OriginalBillDto billDto = new OriginalBillDto();
		for(UserCart item: CartItemsList)
		{    billDto.setCreatedDate(item.getUser().getCreatedDate());
		billDto.setUserType(item.getUser().getUserType());
			originalBill += item.getCatalogueItem().getItemPrice()*item.getQuantity();
		}
		billDto.setOrignalBill(originalBill);
		return billDto;
	}
}
