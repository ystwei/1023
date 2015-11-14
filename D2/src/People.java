
public class People {
	int old;//都叫做成员变量
	int getOld(){//成员方法
		return old;
	}
	void setOld(int old1){
		old=old1;
		
	}
	People(){//默认构造器，形参的个数 顺序 类型，重载overload
		
	}
	People(int old1){//非默认构造器
		old=old1;
	}
	
	public static void main(String[] args) {
		
		People p=new People();//匿名=无名氏=佚名
		p.setOld(100);
		System.out.println(p.getOld());
		
		People p1=new People();
		p1.setOld(1000);
		
		System.out.println(p.getOld());
	}
}
