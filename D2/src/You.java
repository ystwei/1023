
public class You {
	Computer c=null;
	public You(){
		
	}
	public void go(Computer c1){
		c=c1;
	}
	public static void main(String[] args) {
		You y=new You();
		Computer c2=new Computer();
		y.go(c2);//(Date d)
		
	}
}
class Computer{
	
}
