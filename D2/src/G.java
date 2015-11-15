
public class G {
	private int age;
	private String name;
	public G(){//default
		
		age=100;
		name="MIKE";
	}
	public G(int age1){//public 
		this("Œ¿¿•");
		
		age=age1;
	}
	public G(String name){//public 
		this.name=name;
		
	}
	public G(int age1,String name1){//public
		
		this();
		
		age=age1;
		name=name1;
	}
	public G(String name1,int age1){//public 
		this(900,"Alice");
		
		name=name1;
		age=age1;
		
	}
	public int getAge() {
		
		return age;
	}
	public String getName() {
		return name;
	}
	
	public G go(){
		int old=0;
		old++;
		System.out.println(old);
		return this;
	}
	
	public static void main(String[] args) {
		
		System.out.println(new G().go().go().go().go().go());
	}
	
}
