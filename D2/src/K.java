
public class K extends K0 {	
	K(){		
		System.out.println("ok1");
	}	
	public static void main(String[] args) {
		System.out.println(new K().old);
	}
	{//��̬��ʼ��block �� InitXXX
		old=250;
		System.out.println("ok");
	}
}
class K0{
	static int old=100;
	{//��̬��ʼ��block �� InitXXX
		old=150;
		System.out.println("ok2");		
	}
	K0(){
		System.out.println("ok3");	
	}
}
