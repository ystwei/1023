import java.util.Date;


public class F {
	public static void main(String[] args) {
		F f=new F();
		String d1="DEF";
		f.modify(d1);
		
		
		System.out.println(d1);
	}
	//String, Integer,Byte,Short ,Boolean Character,Double Float,Long都是常量，因此不能改变自己，
	//
	public  void modify(String d){//如果形参是引用类型的话，那么，传递的一定是地址，因此相互影响
		d="ABC";		
	}
}
