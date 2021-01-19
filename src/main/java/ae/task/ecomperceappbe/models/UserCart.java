package ae.task.ecomperceappbe.models;

import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Entity
@Table(name = "USER_CART")
public class UserCart {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
	@Column(name="QUANTITY")
	private Long quantity;
	
	@ManyToOne(targetEntity =User.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID",insertable= true , updatable= false)
	private User user ; 
	@ManyToOne(targetEntity =CatalogueItem.class, cascade = CascadeType.ALL) 
	@JoinColumn(name = "ITEM_ID" ,insertable= true , updatable= false)
	private CatalogueItem catalogueItem;
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public CatalogueItem getCatalogueItem() {
		return catalogueItem;
	}
	public void setCatalogueItem(CatalogueItem catalogueItem) {
		this.catalogueItem = catalogueItem;
	}
	
}
