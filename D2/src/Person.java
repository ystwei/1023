
public class Person {
	Hand h=null;
	String s="MIKE";
	public Person(){//Composite
		h=new Hand();
	}
	public void go(){
		h.make();
	}
	public static void main(String[] args) {
		Person p=new Person();
	}
}
class Hand{
	public void make(){
		
	}
}