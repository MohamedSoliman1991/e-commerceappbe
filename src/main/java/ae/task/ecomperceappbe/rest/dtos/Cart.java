package ae.task.ecomperceappbe.rest.dtos;

import java.util.ArrayList;
import java.util.List;

public class Cart {
private Long userId;
private List<SelectedItems> seletedProducts;
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public List<SelectedItems> getSeletedProducts() {
	if(this.seletedProducts==null)
	   seletedProducts = new ArrayList<SelectedItems>();
	return seletedProducts;
}
public void setSeletedProducts(List<SelectedItems> seletedProducts) {
	this.seletedProducts = seletedProducts;
}
}
