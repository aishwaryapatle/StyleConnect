package model;

public class Booking {

	int bid;
	String date;
	String time;
	String services;
	String barbers;
	String name;
	String email;
	String phoneno;
	float price;
	float discountPercentage;
	float discountAmount;
	
	public Booking() {
		super();
	}
	
	public Booking(String date, String time, String services, String barbers, String name, String email, String phoneno,
			float price) {
		super();
		this.date = date;
		this.time = time;
		this.services = services;
		this.barbers = barbers;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.price = price;
	}
	
	public Booking(int bid, String date, String time, String services, String barbers, String name, String email, String phoneno,
			float price, float discountPercentage, float discountAmount) {
		super();
		this.bid = bid;
		this.date = date;
		this.time = time;
		this.services = services;
		this.barbers = barbers;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.price = price;
		this.discountPercentage = discountPercentage;
		this.discountAmount = discountAmount;
	}
	
	public Booking( String date, String time, String services, String barbers, String name, String email,
			String phoneno, float price, float discountPercentage, float discountAmount) {
		super();
		this.date = date;
		this.time = time;
		this.services = services;
		this.barbers = barbers;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.price = price;
		this.discountPercentage = discountPercentage;
		this.discountAmount = discountAmount;
	}

	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String getBarbers() {
		return barbers;
	}
	public void setBarbers(String barbers) {
		this.barbers = barbers;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(float discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public float getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(float discountAmount) {
		this.discountAmount = discountAmount;
	}
	
}
