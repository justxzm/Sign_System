package just.ca.einity;

public class Administrator {
	int number;
	String name;
	String password;
	int times;
	public Administrator() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Administrator(int number, String name, String password, int times) {
		super();
		this.number = number;
		this.name = name;
		this.password = password;
		this.times = times;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}
	
}
