package java01.exam07.vo;

// 3. equals() 재정의 
public class Member /*extends Object*/ {
	protected String name;
	protected int age;
	protected String email;
	protected String tel;
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null || !(obj instanceof Member)) 
			return false;
		
		Member other = (Member)obj;
		if (!this.name.equals(other.name))
			return false;
		if (this.age != other.age)
			return false;
		if (!this.email.equals(other.email))
			return false;
		if (!this.tel.equals(other.tel))
			return false;
		return true;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(this.age > 7 && this.age < 101) {
			this.age = age;
		} else { 
			this.age = 20;
		}
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	

}







