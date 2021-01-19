package ae.task.ecomperceappbe.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import ae.task.ecomperceappbe.controllers.eshopController;
import ae.task.ecomperceappbe.rest.dtos.Cart;
import ae.task.ecomperceappbe.rest.dtos.CheckoutItemsDto;
import ae.task.ecomperceappbe.rest.dtos.SelectedItems;

public class eshopControllerTests {
	
	eshopController mobileController = new eshopController();
	
	
//	 @Test
//	  public void addTocart() {
//		 Cart cart = new Cart();
//		 cart.setUserId(1L);
//		 SelectedItems  selectedItem1 = new SelectedItems();
//		 selectedItem1.setItemId(1l);
//		 selectedItem1.setQuantity(2L);
//		 cart.getSeletedProducts().add(selectedItem1);
//		 List<CheckoutItemsDto> itemsList =  mobileController.addToCart(cart);
//		 assertEquals(1, itemsList.size());
//	 }

		@Autowired
		private MockMvc mockMvc;

		@Test
		public void bill() throws Exception {
			mockMvc.perform(get("http://localhost:8082/eshop/bill/1")).andExpect(status().isOk()).andExpect(content().json("{ \"originalAmount\": 30.0, \"totalBillAmount\": 9.0 }")).
			andExpect(content().contentType("application/json;charset=UTF-8"));
			
		}
		}
	

