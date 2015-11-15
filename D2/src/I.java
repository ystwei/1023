
public class I extends I0 {
	public int old;
	I(int old){
		super(100);
		System.out.println("s-c");//son-constructor
		
	}
	I(){
		super(100);
		System.out.println("s-c");//son-constructor
		
	}
	public void bark(){
		go();
		
	}
	public void go(){
		old=100;
		System.out.println(old);
	}
	public static void main(String[] args) {
		new I(100).go();
		
	}
	
}
class I0{
	
	I0(int age){
		System.out.println("p-c(int)");
	}
	public int old;
	public void go(){
		System.out.println("p-go");
	}
	private void plan(){
		
	}
}