package just.ca.einity;

public class Member {
	long number;
	String name;
	String sex;
	String profession;
	String phone;
	String qqnumber;
	int times;
	public Member() {
		super();
	}
	public Member(long number, String name, String sex, String profession,
			String phone, String qqnumber, int times) {
		super();
		this.number = number;
		this.name = name;
		this.sex = sex;
		this.profession = profession;
		this.phone = phone;
		this.qqnumber = qqnumber;
		this.times = times;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getQqnumber() {
		return qqnumber;
	}
	public void setQqnumber(String qqnumber) {
		this.qqnumber = qqnumber;
	}
	public int getTimes() {
		return times;
	}
	public void setTimes(int times) {
		this.times = times;
	}

}
