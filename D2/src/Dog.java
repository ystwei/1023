
public class Dog {//·â ×°
	
	private  int old;
	private String name;
	
	private int age;
	private char sex;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age1) {
		age = age1;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex1) {
		sex = sex1;
	}
	public int getOld(){
		return old;
	}
	public void setOld(int old1){
		if(old1>200){
			old=100;
		}else{
			old=old1;
		}
		
	}
	
}
