package model;

public class Staff {

	int staffId;
	String staffName;
	String staffEmail;
	String staffMobile;
	String staffGender;
	String staffAddress;
	float staffSalary;
	
	
	public Staff() {
		super();
	}
	
	public Staff(String staffName) {
		super();
		this.staffName = staffName;
	}

	public Staff(String staffName, String staffEmail, String staffMobile, String staffGender, String staffAddress,
			float staffSalary) {
		super();
		this.staffName = staffName;
		this.staffEmail = staffEmail;
		this.staffMobile = staffMobile;
		this.staffGender = staffGender;
		this.staffAddress = staffAddress;
		this.staffSalary = staffSalary;
	}
	
	public Staff(int staffId, String staffName, String staffEmail, String staffMobile, String staffGender,
			String staffAddress, float staffSalary) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffEmail = staffEmail;
		this.staffMobile = staffMobile;
		this.staffGender = staffGender;
		this.staffAddress = staffAddress;
		this.staffSalary = staffSalary;
	}
	
	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffEmail() {
		return staffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		this.staffEmail = staffEmail;
	}
	public String getStaffMobile() {
		return staffMobile;
	}
	public void setStaffMobile(String staffMobile) {
		this.staffMobile = staffMobile;
	}
	public String getStaffGender() {
		return staffGender;
	}
	public void setStaffGender(String staffGender) {
		this.staffGender = staffGender;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	public float getStaffSalary() {
		return staffSalary;
	}
	public void setStaffSalary(float staffSalary) {
		this.staffSalary = staffSalary;
	}
	
	
}
