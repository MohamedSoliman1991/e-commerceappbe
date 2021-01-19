package ae.task.ecomperceappbe.rest.dtos;

public class OriginalBillDto {
	
	private double orignalBill;
	private String userType;
	private String createdDate;
	public double getOrignalBill() {
		return orignalBill;
	}
	public void setOrignalBill(double orignalBill) {
		this.orignalBill = orignalBill;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

}
