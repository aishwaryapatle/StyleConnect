package model;

public class Discount {

	int discountId;
	String discountDay;
	float discount;
	String discountDescription;

	public Discount() {
	}
	
	public Discount(String discountDay, float discount) {
		super();
		this.discountDay = discountDay;
		this.discount = discount;
	}
	
	public Discount(String discountDay, float discount, String discountDescription) {
		super();
		this.discountDay = discountDay;
		this.discount = discount;
		this.discountDescription = discountDescription;
	}

	public Discount(int discountId, String discountDay, float discount, String discountDescription) {
		super();
		this.discountId = discountId;
		this.discountDay = discountDay;
		this.discount = discount;
		this.discountDescription = discountDescription;
	}

	public String getDiscountDay() {
		return discountDay;
	}

	public void setDiscountDay(String discountDay) {
		this.discountDay = discountDay;
	}

	public int getDiscountId() {
		return discountId;
	}
	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public String getDescription() {
		return discountDescription;
	}
	public void setDescription(String description) {
		this.discountDescription = description;
	}
	
	
}
