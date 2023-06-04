package model;

public class Service {
	
	int sid;
	String sname;
	float sprice;
	
	public Service()
	{
		
	}
	
	public Service(String sname) {
		super();
		this.sname = sname;
	}
	
	public Service(String sname, float sprice) {
		super();
		this.sname = sname;
		this.sprice = sprice;
	}
	
	public Service(int sid, String sname, float sprice) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.sprice = sprice;
	}
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public float getSprice() {
		return sprice;
	}
	public void setSprice(float sprice) {
		this.sprice = sprice;
	}

	
}
