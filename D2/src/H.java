
public class H extends H1{
	H(){
		System.out.println("H");
	}	
	public static void main(String[] args) {
		new H();
	}
}
class H1 extends H0{
	H1(){
		System.out.println("H1");
	}
}
class H0{
	H0(){
		System.out.println("H0");
	}
}
