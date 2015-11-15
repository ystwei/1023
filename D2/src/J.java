
public class J extends J1{
	public static void main(String[] args) {
		new J().mark();
	}
	public J1 plan(){
		return new J1();
	}
	public void mark(){
		super.mark();
	}
}
class J1 extends J0{
	public void mark(){
		super.go();
	}
	public void go(){
		System.out.println("p_go");
	}
}
class J0{
	public void go(){
		System.out.println("g_go");
	}
}