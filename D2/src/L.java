
public class L extends L0{
	@Override//annoation
	public  void ok(){//override,���� comments
		
		System.out.println("l-ok");		
	}
	
	
	public static void main(String[] args) {
		System.out.println(new L());
	}
}
class L0{
	private int old;
	private String name;
	public  void ok(){
		System.out.println("l0-ok");
	}
	public String toString(){
		
		return "L0���е�˽�������ǣ�old��name";
	}
}