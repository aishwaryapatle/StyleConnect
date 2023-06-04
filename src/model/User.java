package model;

public class User {

	int uid;
	String name;
	String email;
	String phoneno;
	String password;
	String role;
	
	public User()
	{
		
	};
	
	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public User(String name, String email, String phoneno, String password) {
		super();
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
	}

	public User(int uid, String name, String email, String phoneno, String password, String role) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
		this.role = role;
	}

	public User(String name, String email, String phoneno, String password, String role) {
		super();
		this.name = name;
		this.email = email;
		this.phoneno = phoneno;
		this.password = password;
		this.role = role;
	}

	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "User [uid=" + uid + ", name=" + name + ", email=" + email + ", phoneno=" + phoneno + ", password="
				+ password + ", role=" + role + "]";
	}
	
	
}
